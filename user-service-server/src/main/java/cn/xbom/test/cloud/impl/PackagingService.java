package cn.xbom.test.cloud.impl;

import cn.xbom.test.cloud.api.dto.PackagingDTO;
import cn.xbom.test.cloud.dao.PackagingDAO;
import cn.xbom.test.cloud.entity.PackagingDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/packaging")
public class PackagingService implements cn.xbom.test.cloud.api.module.PackagingService {

    @Autowired
    private PackagingDAO packagingDAO;

    @Override
    public PackagingDTO findPackagingById(Long id) {
        BeanCopier beanCopier = BeanCopier.create(PackagingDO.class, PackagingDTO.class, false);

        PackagingDO packagingInDB = packagingDAO.findPackagingById(id);
        PackagingDTO packagingDTO = new PackagingDTO();
        beanCopier.copy(packagingInDB,packagingDTO,null);

        return packagingDTO;
    }



    @Override
    public List<PackagingDTO> findAll() {
        List<PackagingDO> packagingDAOS = packagingDAO.listAll();
        System.out.println(packagingDAOS);
        return null;
    }
}
