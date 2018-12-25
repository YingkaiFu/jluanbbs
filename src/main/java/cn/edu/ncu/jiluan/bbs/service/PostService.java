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

    public Page<PostEntity> findAllByPlateIdOrderByIsPickedDesc(Integer plateId, Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "isPicked");
        return postDao.findAllByPlateIdOrderByIsPickedDesc(plateId, pageable);
    }
    public List<PostEntity> findAll(){ return postDao.findAll(); }
    public Long count() {return postDao.count();}
    public Page<PostEntity> findAllPagedOrderByPostId(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "postId");
        return postDao.findAll(pageable);
    }

    public void addView(int post_id) {
        postDao.addView(post_id);
    }
    public void deletePostEntityByPostId(Integer postId){
        postDao.deletePostEntityByPostId(postId);
    }

    public List<PostEntity> findPostEntitiesByIspost(Byte isPost){
        return postDao.findPostEntitiesByIspost(isPost);
    }

    public PostEntity findPostEntityByPostId(Integer postId, Byte isPost){
        return postDao.findPostEntityByPostIdAndIspost(postId,isPost);
    }
    public PostEntity addPost(PostEntity postEntity){
        return postDao.save(postEntity);
    }
    public PostEntity editPost(PostEntity postEntity){
        return postDao.save(postEntity);
    }

    public void editPicked(int postId, boolean isEnable){
        if(isEnable == false)
            postDao.editPicked(Byte.valueOf("1"),postId);
        else
            postDao.editPicked(Byte.valueOf("0"),postId);

    }

    public void editGood(int postId, boolean isEnable){
        if(isEnable == false)
            postDao.editGood(Byte.valueOf("1"),postId);
        else
            postDao.editGood(Byte.valueOf("0"),postId);
    };

}
