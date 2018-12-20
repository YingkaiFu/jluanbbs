package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.entity.PostLikedEntity;
import cn.edu.ncu.jiluan.bbs.service.PostLikedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by krito on 2018/12/20
 */
@RestController
@RequestMapping(value = "postLiked")
public class PostLikedController {
    @Autowired
    private PostLikedService service;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<PostLikedEntity> findAll(){
        return service.findAll();
    }
}
