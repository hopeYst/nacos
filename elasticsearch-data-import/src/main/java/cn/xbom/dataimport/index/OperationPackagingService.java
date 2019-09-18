package cn.xbom.dataimport.index;

import cn.xbom.dataimport.entity.XbomPackaging;

import java.util.List;

public interface OperationPackagingService {

    void batchDataWritng(List<XbomPackaging> dataSource);

    List<XbomPackaging> findAllPackages();

    void deleteAll();

    XbomPackaging findById(Long id);
}
