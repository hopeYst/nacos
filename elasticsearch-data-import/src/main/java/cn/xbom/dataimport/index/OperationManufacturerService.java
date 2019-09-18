package cn.xbom.dataimport.index;


import cn.xbom.dataimport.entity.XbomManufacturer;
import cn.xbom.test.cloud.api.dto.ManufacturerDTO;

import java.util.List;

public interface OperationManufacturerService {

    List<XbomManufacturer> findAll();

    void batchDataWriting(List<XbomManufacturer> dataSource);

    void deleteAll();

}
