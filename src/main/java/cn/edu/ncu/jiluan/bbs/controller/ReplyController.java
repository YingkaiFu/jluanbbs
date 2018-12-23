package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.entity.ReplyEntity;
import cn.edu.ncu.jiluan.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by krito on 2018/12/20
 */
@Controller
@RequestMapping(value = "reply")
public class ReplyController {
    @Autowired
    private ReplyService service;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<ReplyEntity> findAll(){
        return service.findAll();
    }
}
