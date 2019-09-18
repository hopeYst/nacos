package cn.xbom.dataimport.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(
        indexName = "xbom-product",
        type = "product"
)
public class XbomProduct {

    @Id
    private Long id;
    private String dkNumber;
    private String mfgNumber;
    private String description;
    private Long manufacturerId;
    private Long packagingId;
    private String marketplaceStatusId;
    private String extendedDescription;
    private Long categoryId;
    private String fee;
}
