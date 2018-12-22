package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.entity.PostEntity;
import cn.edu.ncu.jiluan.bbs.service.PlateService;
import cn.edu.ncu.jiluan.bbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by krito on 2018/12/20
 */
@Controller
@RequestMapping(value = "")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private PlateService plateService;

    @RequestMapping(value = "post",method = RequestMethod.GET)
    public List<PostEntity> findAll(){
        return postService.findAll();
    }

    @RequestMapping(value = "/plateMgr/{plateId}/postDel/{postId}",method = RequestMethod.GET)
    public String deletePostEntityByPostId(@PathVariable Integer plateId, @PathVariable Integer postId){
        postService.deletePostEntityByPostId(postId);
        return "redirect:/plateMgr/{plateId}";
    }


}
