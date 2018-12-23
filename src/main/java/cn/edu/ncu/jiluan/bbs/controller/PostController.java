package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.entity.PlateEntity;
import cn.edu.ncu.jiluan.bbs.entity.PostEntity;
import cn.edu.ncu.jiluan.bbs.entity.UserEntity;
import cn.edu.ncu.jiluan.bbs.service.PlateService;
import cn.edu.ncu.jiluan.bbs.service.PostService;
import cn.edu.ncu.jiluan.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/postList",method = RequestMethod.GET)
    public String  findAll(Model model){
        model.addAttribute("postList",postService.findAll());
        model.addAttribute("plateList",plateService.findAll());
        return "home";

    }

    @RequestMapping(value = "/plateMgr/{plateId}/postDel/{postId}",method = RequestMethod.GET)
    public String deletePostEntityByPostId(@PathVariable Integer plateId, @PathVariable Integer postId){
        postService.deletePostEntityByPostId(postId);
        return "redirect:/plateMgr/{plateId}";
    }

    @RequestMapping(value = "/addNewPost",method = RequestMethod.GET)
    public String getPlate(Model model){
        model.addAttribute("plateList",plateService.findAll());
        model.addAttribute("post",new PostEntity());
        return "postAdd";
    }

    @RequestMapping(value = "/addPost",method = RequestMethod.POST)
    public String postAdd(@Valid PostEntity postEntity, HttpServletRequest request){
        HttpSession session=request.getSession();
        UserEntity user = userService.findUserEntityByUserName((String)session.getAttribute("userName"));
        postEntity.setUserId(user.getUserId());
        postEntity.setPostTime(new Timestamp(System.currentTimeMillis()));
        postService.addPost(postEntity);
        return "redirect:/postList";
    }



}
