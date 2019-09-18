package cn.xbom.dataimport.contorller;

import cn.xbom.dataimport.dao.OperationPackagingDAO;
import cn.xbom.dataimport.entity.XbomPackaging;
import cn.xbom.test.cloud.api.dto.PackagingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PackagingContorller {

    @Autowired(required = false)
    private PackageService packageService;

    @Autowired
    private OperationPackagingDAO elasticSearchPackagingDAO;

    @GetMapping("/feign/hello")
    public List hello(){
        List<PackagingDTO> all = packageService.findAll();
        return all;
    }

    @GetMapping("/search/packaging")
    public String word(@RequestParam("id") String id){
            Optional<XbomPackaging> byId = elasticSearchPackagingDAO.findById(id);
        XbomPackaging xbomPackaging = byId.get();
        return xbomPackaging.toString();
    }

    @PostMapping("/packaging/save")
    public String savePackaging(@RequestParam("id") Long id, @RequestParam("name") String name){
        XbomPackaging packaging = new XbomPackaging();
        packaging.setId(id);
        packaging.setName(name);
        XbomPackaging index = elasticSearchPackagingDAO.index(packaging);
        return index.toString();
    }

    @FeignClient(name = "User-Service", path = "/packaging")
    public interface PackageService extends cn.xbom.test.cloud.api.module.PackagingService {
    }

}
