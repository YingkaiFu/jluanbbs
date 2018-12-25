package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.entity.ReplyEntity;
import cn.edu.ncu.jiluan.bbs.service.PostService;
import cn.edu.ncu.jiluan.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by krito on 2018/12/20
 */
@Controller
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @Autowired
    private PostService postService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<ReplyEntity> findAll(){
        return replyService.findAll();
    }

    @RequestMapping(value = "/post/{postId}/addReply", method = RequestMethod.POST)
    public String addReply(@Valid ReplyEntity replyEntity, HttpServletRequest request, @PathVariable int postId){
        HttpSession session = request.getSession();
        replyEntity.setUserId((Integer)session.getAttribute("userId"));
        replyService.addReply(replyEntity);
        replyService.updatePostRepliesCount(replyEntity.getPostId());
        postService.editLastReply(postId, new Timestamp(System.currentTimeMillis()));
        return "redirect:/post/{postId}";
    }

    @RequestMapping(value = "/question/{postId}/addReply", method = RequestMethod.POST)
    public String addQuestionReply(@Valid ReplyEntity replyEntity, HttpServletRequest request){
        HttpSession session = request.getSession();
        replyEntity.setUserId((Integer)session.getAttribute("userId"));
        replyService.addReply(replyEntity);
        replyService.updatePostRepliesCount(replyEntity.getPostId());
        return "redirect:/question/{postId}";
    }
}
