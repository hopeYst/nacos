package cn.xbom.dataimport;

import cn.xbom.dataimport.entity.XbomManufacturer;
import cn.xbom.dataimport.impl.OperationManufacturerServicelmpl;
import cn.xbom.dataimport.index.OperationManufacturerService;
import cn.xbom.dataimport.index.OperationPackagingService;
import cn.xbom.dataimport.entity.XbomPackaging;
import cn.xbom.test.cloud.api.dto.ManufacturerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.List;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ElasticsearchDataImportApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchDataImportApplication.class, args);
    }


    @Autowired
    private OperationManufacturerService operationManufacturerService;

    @Autowired
    private OperationPackagingService operationPackagingService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<XbomManufacturer> all = operationManufacturerService.findAll();
        operationManufacturerService.batchDataWriting(all);

    }

}
