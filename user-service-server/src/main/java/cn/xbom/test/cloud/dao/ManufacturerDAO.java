package cn.xbom.test.cloud.dao;

import cn.xbom.test.cloud.entity.ManufacturerDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.util.List;

@MapperScan
@Component
public interface ManufacturerDAO {

    String FIELDS = "id,name,url";

    @Select(value = "SELECT "+FIELDS+" FROM digikey_manufacturer")
    List<ManufacturerDO> queryPage();

    @Select(value = "SELECT "+FIELDS+" FROM digikey_manufacturer WHERE id = #{id}")
    ManufacturerDO findById(@Param("id") Long id);

    @Select(value = "SELECT "+FIELDS+" FROM digikey_manufacturer")
    List<ManufacturerDO> findAll();
}
