package cn.xbom.test.cloud.web.controller;

import cn.xbom.test.cloud.api.dto.PackagingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PackagingController {

    @Autowired
    private PackagingService packagingService;

    @GetMapping("/package/findById")
    public PackagingDTO findPacking(@RequestParam("id") Long id){
        return packagingService.findPackagingById(id);
    }

    @GetMapping("/package/all")
    public List listAll(){
        return packagingService.findAll();
    }


    @FeignClient(name = "User-Service", path = "/packaging")
    public interface PackagingService extends cn.xbom.test.cloud.api.module.PackagingService{
    }

}
