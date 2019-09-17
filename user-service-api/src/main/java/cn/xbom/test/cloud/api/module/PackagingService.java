package cn.xbom.test.cloud.api.module;

import cn.xbom.test.cloud.api.dto.PackagingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("User-service")
public interface PackagingService {

    @GetMapping("/packaging/find")
    PackagingDTO findPackagingById(@RequestParam("id") Long id);

    @GetMapping("/listAll")
    List<PackagingDTO> findAll();
}
