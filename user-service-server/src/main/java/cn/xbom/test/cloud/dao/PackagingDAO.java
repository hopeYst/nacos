package cn.xbom.test.cloud.dao;

import cn.xbom.test.cloud.entity.PackagingDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PackagingDAO {

    @Select(value = "SELECT id,name FROM digikey_packaging WHERE id = #{id}")
    PackagingDO findPackagingById(@Param("id") Long id);


    List<PackagingDO> listAll();
}
