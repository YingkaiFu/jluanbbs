package cn.edu.ncu.jiluan.bbs.service;

import cn.edu.ncu.jiluan.bbs.dao.CityDao;
import cn.edu.ncu.jiluan.bbs.entity.CityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by krito on 2018/12/24
 */
@Service
public class CityService {
    @Autowired
    private CityDao cityDao;

    public List<CityEntity> findAll() {return cityDao.findAll();}
}
