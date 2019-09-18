package cn.xbom.dataimport.impl;

import cn.xbom.dataimport.index.OperationPackagingService;
import cn.xbom.dataimport.dao.OperationPackagingDAO;
import cn.xbom.dataimport.entity.XbomPackaging;
import cn.xbom.test.cloud.api.dto.PackagingDTO;
import cn.xbom.test.cloud.api.module.PackagingService;
import cn.xbom.test.cloud.api.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperationPackagesServiceImpl implements OperationPackagingService {

    private static final BeanCopier BEAN_COPIER = BeanCopier.create(PackagingDTO.class, XbomPackaging.class, false);

    @Autowired
    private ElasticsearchTemplate template;
    @Autowired(required = false)
    private ReadPackaging readPackaging;
    @Autowired
    private OperationPackagingDAO operationPackagingDAO;

    @Override
    public void batchDataWritng(List<XbomPackaging> dataSource) {
        List<IndexQuery> queries = new ArrayList<>();
        dataSource.forEach(pa -> {
            IndexQuery index = new IndexQuery();
            index.setId(pa.getId().toString());
            index.setObject(pa);
            index.setIndexName("xbom-package");
            index.setType("packaging");
            queries.add(index);
        });
        template.bulkIndex(queries);
    }

    @Override
    public List<XbomPackaging> findAllPackages() {
        List<PackagingDTO> all = readPackaging.findAll();

        List<XbomPackaging> list = new ArrayList<>();
        all.forEach(dto -> {
            XbomPackaging xbomPackaging = new XbomPackaging();
            BEAN_COPIER.copy(dto, xbomPackaging, null);
            list.add(xbomPackaging);
        });
        return list;
    }

    @Override
    public void deleteAll() {
        operationPackagingDAO.deleteAll();
    }

    @Override
    public XbomPackaging findById(Long id) {
        PackagingDTO packagingById = readPackaging.findPackagingById(1L);
        System.out.println(packagingById+"===========================");
        return null;
    }


    @FeignClient(name = "User-Service", path = "/packaging")
    private interface ReadPackaging extends PackagingService {
    }

}
