package cn.xbom.dataimport.dao;

import cn.xbom.dataimport.entity.XbomPackaging;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface ElasticSearchPackagingDAO extends ElasticsearchRepository<XbomPackaging,String> {
}
