package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.entity.PlateEntity;
import cn.edu.ncu.jiluan.bbs.entity.PostEntity;
import cn.edu.ncu.jiluan.bbs.service.PlateService;
import cn.edu.ncu.jiluan.bbs.service.PostService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by krito on 2018/12/20
 */
@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private PlateService plateService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String  findAll(Model model){
        model.addAttribute("postList",postService.findAll());
        return "home";

    }

    @RequestMapping(value = "/postDel/{postId}",method = RequestMethod.GET)
    public String deletePostEntityByPostId(@PathVariable Integer postId){
        postService.deletePostEntityByPostId(postId);
        return "postMgr";
    }

    @RequestMapping(value = "/addNewPost",method = RequestMethod.GET)
    public String getPlate(PostEntity postEntity, Model model){
        model.addAttribute("plateList",plateService.findAll());
        model.addAttribute("post",new PostEntity());
//        postService.addPost(postEntity);
        return "postAdd";
    }

    @RequestMapping(value = "/addPost",method = RequestMethod.POST)
    public String postAdd(@Valid PostEntity postEntity, Model model){
        System.out.println(postEntity.getPostCont());

        postEntity.setPostTime(new Timestamp(System.currentTimeMillis()));
        postService.addPost(postEntity);
        model.addAttribute("topic",postEntity.getPostTopic());
        model.addAttribute("plate",postEntity.getPlateId());
        model.addAttribute("content",postEntity.getPostCont());
        return "testResult";
    }

}
