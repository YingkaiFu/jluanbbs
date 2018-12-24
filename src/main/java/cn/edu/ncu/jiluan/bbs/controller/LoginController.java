package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.entity.UserEntity;
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

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView toLogin(){
        ModelAndView modelAndView = new ModelAndView();
        UserEntity user = new UserEntity();
        modelAndView.addObject("current",user);
        modelAndView.setViewName("login");
        return modelAndView;
    }



    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String Login(@Valid UserEntity userEntity, HttpServletRequest request, Model model){
        ModelAndView modelAndView = new ModelAndView();
        String message="";
        int n = userService.login(userEntity.getUserName(),userEntity.getPassword());
        HttpSession session=request.getSession();
        if(n==0) {
            //获取session并将userName存入session对象
            session.setAttribute("userName", userEntity.getUserName());
            session.setAttribute("userId", userService.findUserEntityByUserName(userEntity.getUserName()).getUserId());
            if(userEntity.getUserName().equals("admin"))
                return "redirect:/adminPage";
            return "redirect:/";
        }
        else{
            if(n==1){
                message="该用户未注册";
                return "redirect:/registration";
            }
        }
        return "redirect:/login";
    }
    @RequestMapping(value = {"/logOut"}, method = RequestMethod.GET)
    public String Login(HttpServletRequest request, Model model){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session=request.getSession();
        session.removeAttribute("userName");//获取session并将userName存入session对象
        session.removeAttribute("userId");
        return "redirect:/";
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        UserEntity user = new UserEntity();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid UserEntity user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(user.getUserName());
        UserEntity userExists = userService.findUserEntityByUserName(user.getUserName());
        if (userExists != null) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "该用户名已经被注册了");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "注册成功");
            modelAndView.addObject("user", new UserEntity());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userName", "Welcome");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("emm");
        return modelAndView;
    }


}
