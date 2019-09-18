package cn.xbom.dataimport.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@Document(
        indexName = "xbom-manufacturer",
        type = "manufacturer"
)
public class XbomManufacturer {

    @Id
    private Long id;
    @Field
    private String name;
    private String url;
}
