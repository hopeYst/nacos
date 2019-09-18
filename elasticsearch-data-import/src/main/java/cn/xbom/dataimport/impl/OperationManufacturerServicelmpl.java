package cn.xbom.dataimport.impl;

import cn.xbom.dataimport.index.OperationManufacturerService;
import cn.xbom.dataimport.entity.XbomManufacturer;
import cn.xbom.test.cloud.api.dto.ManufacturerDTO;
import cn.xbom.test.cloud.api.module.ManufacturerService;
import cn.xbom.test.cloud.api.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperationManufacturerServicelmpl implements OperationManufacturerService {
    
    @Autowired(required = false)
    private FeignManufacturerService feignManufacturerService;

    @Autowired
    private ElasticsearchTemplate template;

    private Convert convert = Convert.buildConvert();
    
    @Override
    public List<XbomManufacturer> findAll() {
        List<ManufacturerDTO> all = feignManufacturerService.findAll();
        List<XbomManufacturer> list = null;
        try {
             list = convert.copierList(all, XbomManufacturer.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void batchDataWriting(List<XbomManufacturer> dataSource) {

        ArrayList<IndexQuery> indexQueries = new ArrayList<>();
        dataSource.forEach(data->{
            IndexQuery index = new IndexQuery();
            index.setIndexName("xbom-manufacturer");
            index.setType("manufacturer");
            index.setObject(data);
            index.setId(data.getId().toString());
            indexQueries.add(index);
        });
        template.bulkIndex(indexQueries);

    }

    @Override
    public void deleteAll() {
    }

    
    @FeignClient(name = "User-Service", path = "/manufacturer")
    private interface FeignManufacturerService extends ManufacturerService{
    }
    
}
