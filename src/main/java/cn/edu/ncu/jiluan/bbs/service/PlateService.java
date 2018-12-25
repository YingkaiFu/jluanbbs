package cn.edu.ncu.jiluan.bbs.service;

import cn.edu.ncu.jiluan.bbs.dao.PlateDao;
import cn.edu.ncu.jiluan.bbs.dao.PostDao;
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

    public PlateEntity findPlateEntityByPlateId(Integer plateId){
        return plateDao.findPlateEntityByPlateId(plateId);
    }

    public void deletePlateEntityByPlateId(Integer plateId){
        plateDao.deletePlateEntityByPlateId(plateId);
    }

    public PlateEntity savePlate(PlateEntity plateEntity){
        return plateDao.save(plateEntity);
    }
}
