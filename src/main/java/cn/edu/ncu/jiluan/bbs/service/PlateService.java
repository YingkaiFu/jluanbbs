package cn.edu.ncu.jiluan.bbs.service;

import cn.edu.ncu.jiluan.bbs.dao.PlateDao;
import cn.edu.ncu.jiluan.bbs.entity.PlateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlateService    {
    @Autowired
    private PlateDao plateDao;

    public List<PlateEntity> findAll(){
        return plateDao.findAll();
    }
}
