package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.entity.UserEntity;
import cn.edu.ncu.jiluan.bbs.service.CityService;
import cn.edu.ncu.jiluan.bbs.service.PlateService;
import cn.edu.ncu.jiluan.bbs.service.ProvinceService;
import cn.edu.ncu.jiluan.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private PlateService plateService;

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private CityService cityService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView toLogin() {
        ModelAndView modelAndView = new ModelAndView();
        UserEntity user = new UserEntity();
        modelAndView.addObject("current", user);
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String Login(@Valid UserEntity userEntity, HttpServletRequest request, Model model) {
        ModelAndView modelAndView = new ModelAndView();

        String message = "";
        int n = userService.login(userEntity.getUserName(), userEntity.getPassword());
        HttpSession session = request.getSession();
        session.removeAttribute("regFlag");
        if (n == 0) {
            //获取session并将userName存入session对象
            session.setAttribute("userName", userEntity.getUserName());
            session.setAttribute("userId", userService.findUserEntityByUserName(userEntity.getUserName()).getUserId());
            return "redirect:/";
        } else {
            if (n == 1) {
                session.setAttribute("Message",1);
                return "redirect:/registration";
            }
            if(n==-1){
                session.setAttribute("Message",-1);
                return "redirect:/login";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping(value = {"/logOut"}, method = RequestMethod.GET)
    public String Login(HttpServletRequest request, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        session.removeAttribute("userName");//获取session并将userName存入session对象
        session.removeAttribute("userId");
        return "redirect:/";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("Message", "");
        model.addAttribute("plates", plateService.findAll());
        model.addAttribute("provinces", provinceService.findAll());
        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("user", new UserEntity());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createNewUser(@Valid UserEntity user,Model model,HttpServletRequest request) {
        System.out.println(user.getUserName());
        HttpSession session=request.getSession();
        UserEntity userExists = userService.findUserEntityByUserName(user.getUserName());
        System.out.println(userExists);
        if (userExists != null) {
            session.setAttribute("regFlag", "0");
            return "redirect:/registration";
        } else {
            userService.saveUser(user);
            session.setAttribute("regFlag", "1");
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userName", "Welcome");
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.setViewName("emm");
        return modelAndView;
    }


}
