package cn.edu.ncu.jiluan.bbs.service;

import cn.edu.ncu.jiluan.bbs.dao.ProvinceDao;
import cn.edu.ncu.jiluan.bbs.entity.ProvinceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by krito on 2018/12/24
 */
@Service
public class ProvinceService {
    @Autowired
    private ProvinceDao provinceDao;

    public List<ProvinceEntity> findAll() {return provinceDao.findAll();}
}
