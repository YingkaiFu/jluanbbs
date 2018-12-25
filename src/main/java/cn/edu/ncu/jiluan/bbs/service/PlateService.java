package cn.edu.ncu.jiluan.bbs.service;

import cn.edu.ncu.jiluan.bbs.dao.PlateDao;
import cn.edu.ncu.jiluan.bbs.dao.PostDao;
import cn.edu.ncu.jiluan.bbs.entity.PlateAnalysisInfo;
import cn.edu.ncu.jiluan.bbs.entity.PlateEntity;
import cn.edu.ncu.jiluan.bbs.entity.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlateService    {
    @Autowired
    private PlateDao plateDao;

    @Autowired
    private PostDao postDao;

    public List<PlateEntity> findAll(){
        return plateDao.findAll();
    }

    public Page<PostEntity> findPostEntitiesByPlateId(Integer plateId, Integer page, Integer size){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "postId");
        return postDao.findPostEntitiesByPlateId(plateId, pageRequest);
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

    public List<PlateAnalysisInfo> getPlateAyalysisInfoList(){
        plateDao.count();
        List<PlateAnalysisInfo> list = new ArrayList<>();
        for (int i=1; i<=plateDao.count(); i++){
            PlateAnalysisInfo plateAnalysisInfo = new PlateAnalysisInfo(plateDao.findPlateEntityByPlateId(i));
            plateAnalysisInfo.setPostCount(postDao.countPostEntityByPlateId(i));
            list.add(plateAnalysisInfo);
        }
        return list;
    }
}
