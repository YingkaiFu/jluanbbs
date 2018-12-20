package cn.edu.ncu.jiluan.bbs.service;

import cn.edu.ncu.jiluan.bbs.dao.PostLikedDao;
import cn.edu.ncu.jiluan.bbs.entity.PostLikedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by krito on 2018/12/20
 */
@Service
public class PostLikedService {
    @Autowired
    private PostLikedDao postLikedDao;

    public List<PostLikedEntity> findAll(){
        return postLikedDao.findAll();
    }
}
