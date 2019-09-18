package cn.xbom.test.cloud.api.module;

import cn.xbom.test.cloud.api.dto.ManufacturerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("User-Service")
public interface ManufacturerService {

    @GetMapping("/manufacturer/queryPage")
    List<ManufacturerDTO> queryPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @GetMapping("/manufacturer/find")
    ManufacturerDTO findById(@RequestParam("id") Long id);

    @GetMapping("/manufacturer/all")
    List<ManufacturerDTO> findAll();
}
