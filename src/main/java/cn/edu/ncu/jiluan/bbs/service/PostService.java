package cn.edu.ncu.jiluan.bbs.service;

import cn.edu.ncu.jiluan.bbs.dao.PostDao;
import cn.edu.ncu.jiluan.bbs.entity.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by krito on 2018/12/20
 */
@Service
public class PostService {
    @Autowired
    private PostDao postDao;

    public List<PostEntity> findAll(){ return postDao.findAll(); }
}
