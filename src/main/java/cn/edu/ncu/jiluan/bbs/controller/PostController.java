package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.entity.PostEntity;
import cn.edu.ncu.jiluan.bbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by krito on 2018/12/20
 */
@RestController
@RequestMapping(value = "post")
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<PostEntity> findAll(){
        return postService.findAll();
    }

    @RequestMapping(value = "/postDel/{postId}",method = RequestMethod.GET)
    public String deletePostEntityByPostId(@PathVariable Integer postId){
        postService.deletePostEntityByPostId(postId);
        return "postMgr";
    }
}
