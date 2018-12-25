package cn.edu.ncu.jiluan.bbs.service;

import cn.edu.ncu.jiluan.bbs.dao.PostDao;
import cn.edu.ncu.jiluan.bbs.entity.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Long count() {return postDao.count();}
    public Page<PostEntity> findAllPagedOrderByPostId(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "postId");
        return postDao.findAll(pageable);
    }

    public void deletePostEntityByPostId(Integer postId){
        postDao.deletePostEntityByPostId(postId);
    }

    public List<PostEntity> findPostEntitiesByIspost(Byte isPost){
        return postDao.findPostEntitiesByIspost(isPost);
    }

    public PostEntity findPostEntityByPostId(Integer postId){
        return postDao.findPostEntityByPostId(postId);
    }
    public PostEntity addPost(PostEntity postEntity){
        return postDao.save(postEntity);
    }
    public PostEntity editPost(PostEntity postEntity){
        return postDao.save(postEntity);
    }
}
