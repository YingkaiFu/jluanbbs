package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.entity.UserEntity;
import cn.edu.ncu.jiluan.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by krito on 2018/12/19
 */
@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService service;
    /**
     @Description 获取全部分类信息
     @Param
     @Return List<UserEntity>
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<UserEntity> findAll(){
        return service.findAll();
    }
}
