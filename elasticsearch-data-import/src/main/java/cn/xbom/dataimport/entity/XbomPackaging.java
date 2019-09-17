package cn.xbom.dataimport.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@Document(
        indexName = "xbom-package",
        type = "packaging"
)
public class XbomPackaging {

    @Id
    private String id;
    @Field()
    private String name;

}
