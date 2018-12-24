package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.entity.UserEntity;
import cn.edu.ncu.jiluan.bbs.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by krito on 2018/12/19
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PlateService plateService;

    @Autowired
    private PostService postService;

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private CityService cityService;


    @RequestMapping(value = "userInfo/{userId}",method = RequestMethod.GET)
    public String findUserEntityByUserId(Model model, @PathVariable Integer userId){
        model.addAttribute("user", userService.findUserEntityByUserId(userId));
        model.addAttribute("plates",plateService.findAll());
        model.addAttribute("posts",postService.findAll());
        return "userInfo";
    }

    @RequestMapping(value = "userMgr",method = RequestMethod.GET)
    public String findAll(Model model){
        model.addAttribute("userList",userService.findAll());
        return "userMgr";
    }

    @RequestMapping(value = "/userDel/{userId}",method = RequestMethod.GET)
    public String deleteUserEntityByUserId(@PathVariable Integer userId){
        userService.deleteUserEntityByUserId(userId);
        return "userMgr";
    }

    @RequestMapping(value = "/toEditUser/{userId}", method = RequestMethod.GET)
    public String toEditUser(Model model, @PathVariable Integer userId){
        model.addAttribute("user", userService.findUserEntityByUserId(userId));
        model.addAttribute("provinceList",provinceService.findAll());
        model.addAttribute("plateList",plateService.findAll());
        return "userEdit";
    }

    @RequestMapping(value = "/editUser",method = RequestMethod.POST)
    public String editUser(UserEntity userEntity){
        userService.editUser(userEntity);
        return "redirect:/";
    }


}
