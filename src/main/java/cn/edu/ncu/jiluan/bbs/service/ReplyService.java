package cn.edu.ncu.jiluan.bbs.service;

import cn.edu.ncu.jiluan.bbs.dao.ReplyDao;
import cn.edu.ncu.jiluan.bbs.entity.ReplyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public int countReplyEntityByPostId(Integer postId){
        return replyDao.countReplyEntityByPostId(postId);
    }
    public void deleteReplyEntitiesByPostId(Integer postId){
        replyDao.deleteReplyEntitiesByPostId(postId);
    }
    public ReplyEntity addReply(ReplyEntity replyEntity){
        return replyDao.save(replyEntity);
    }

    public void updatePostRepliesCount(int postId){
        int replies = replyDao.countReplyEntityByPostId(postId);
        replyDao.updatePostRepliesCount(replies, postId);
    }

}
