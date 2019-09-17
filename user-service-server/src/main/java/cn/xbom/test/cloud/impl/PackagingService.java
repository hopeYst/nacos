package cn.xbom.test.cloud.impl;

import cn.xbom.test.cloud.api.dto.PackagingDTO;
import cn.xbom.test.cloud.dao.PackagingDAO;
import cn.xbom.test.cloud.entity.PackagingDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/packaging")
public class PackagingService implements cn.xbom.test.cloud.api.module.PackagingService {

    @Autowired
    private PackagingDAO packagingDAO;

    private static final BeanCopier BEAN_COPIER = BeanCopier.create(PackagingDO.class, PackagingDTO.class, false);

    @Override
    public PackagingDTO findPackagingById(Long id) {


        PackagingDO packagingInDB = packagingDAO.findPackagingById(id);
        PackagingDTO packagingDTO = new PackagingDTO();
        BEAN_COPIER.copy(packagingInDB,packagingDTO,null);

        return packagingDTO;
    }



    @Override
    public List<PackagingDTO> findAll() {
        List<PackagingDO> packagingDAOS = packagingDAO.listAll();
        ArrayList<PackagingDTO> dtos = new ArrayList<>();
        packagingDAOS.stream().forEach(d -> {
            PackagingDTO dto = new PackagingDTO();
            BEAN_COPIER.copy(d,dto,null);
            dtos.add(dto);
        });
        return dtos;
    }
}
