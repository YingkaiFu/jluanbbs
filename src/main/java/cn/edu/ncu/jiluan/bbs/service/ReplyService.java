package cn.edu.ncu.jiluan.bbs.service;

import cn.edu.ncu.jiluan.bbs.dao.ReplyDao;
import cn.edu.ncu.jiluan.bbs.entity.ReplyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by krito on 2018/12/20
 */
@Service
public class ReplyService {
    @Autowired
    private ReplyDao replyDao;

    public List<ReplyEntity> findAll(){
        return replyDao.findAll();
    }
    public List<ReplyEntity> findReplyEntitiesByPostId(Integer postId){
        return replyDao.findReplyEntitiesByPostId(postId);
    }
}
