package cn.xbom.test.cloud.impl;

import cn.xbom.test.cloud.api.dto.ManufacturerDTO;
import cn.xbom.test.cloud.api.utils.Convert;
import cn.xbom.test.cloud.dao.ManufacturerDAO;
import cn.xbom.test.cloud.entity.ManufacturerDO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturerService implements cn.xbom.test.cloud.api.module.ManufacturerService {

    @Autowired
    private ManufacturerDAO manufacturerDAO;

    private Convert convert = Convert.buildConvert();

    @Override
    public List<ManufacturerDTO> queryPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ManufacturerDO> manufacturerDOS = manufacturerDAO.queryPage();
        PageInfo<ManufacturerDO> info = new PageInfo<>(manufacturerDOS);


        List<ManufacturerDO> list = info.getList();
        BeanCopier beanCopier = BeanCopier.create(ManufacturerDO.class, ManufacturerDTO.class, false);
        ArrayList<ManufacturerDTO> dtos = new ArrayList<>();
        list.forEach(inDB -> {
            ManufacturerDTO dto = new ManufacturerDTO();
            beanCopier.copy(inDB, dto, null);
            dtos.add(dto);
        });
        return dtos;
    }


    @Override
    public ManufacturerDTO findById(Long id) {
        ManufacturerDO inDB = manufacturerDAO.findById(id);
        ManufacturerDTO copier = null;
        try {
            copier = (ManufacturerDTO)convert.copier(inDB, ManufacturerDTO.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return copier;
    }


    @Override
    public List<ManufacturerDTO> findAll() {

        List<ManufacturerDO> all = manufacturerDAO.findAll();
        List list = new ArrayList<>();
        try {
            list = convert.copierList(all, ManufacturerDTO.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return list;
    }
}
