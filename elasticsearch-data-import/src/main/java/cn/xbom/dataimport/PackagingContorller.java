package cn.xbom.dataimport;

import cn.xbom.dataimport.dao.ElasticSearchPackagingDAO;
import cn.xbom.dataimport.entity.XbomPackaging;
import cn.xbom.test.cloud.api.dto.PackagingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PackagingContorller {

    @Autowired(required = false)
    private PackageService packageService;

    @Autowired
    private ElasticSearchPackagingDAO elasticSearchPackagingDAO;

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

    @FeignClient(name = "User-Service", path = "/packaging")
    public interface PackageService extends cn.xbom.test.cloud.api.module.PackagingService {
    }

}
