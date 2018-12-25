package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.entity.PostEntity;
import cn.edu.ncu.jiluan.bbs.entity.ReplyEntity;
import cn.edu.ncu.jiluan.bbs.service.PostService;
import cn.edu.ncu.jiluan.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "")
public class ViewController {
    @Autowired
    private PostService postService;
    @Autowired
    private ReplyService replyService;

    @RequestMapping(value = "/post/{postId}",method = RequestMethod.GET)
    public String GetPostContent(@PathVariable Integer postId, Model model, HttpServletRequest request){
        PostEntity post = postService.findPostEntityByPostId(postId, Byte.valueOf("0"));
        HttpSession session = request.getSession();
        model.addAttribute("post", post);
        model.addAttribute("replyList",replyService.findReplyEntitiesByPostId(postId));
        model.addAttribute("reply",new ReplyEntity());
        postService.addView(postId);
        return "postContent";
    }

}
