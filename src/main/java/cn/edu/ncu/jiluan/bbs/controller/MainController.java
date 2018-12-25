package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.entity.PlateEntity;
import cn.edu.ncu.jiluan.bbs.entity.PostEntity;
import cn.edu.ncu.jiluan.bbs.service.PlateService;
import cn.edu.ncu.jiluan.bbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private PlateService plateService;

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String viewPlate(HttpServletRequest request){
        HttpSession session=request.getSession();
        return "home";
    }

    @RequestMapping("/plate")
    public String getPlates(Model model){
        model.addAttribute("plateList",plateService.findAll());
        return "fragments/plates";
    }
    @RequestMapping("/questions")
    public String getQuestions(Model model){
        model.addAttribute("quesList",postService.findPostEntitiesByIspost(Byte.valueOf("1")));
        return "fragments/question";
    }
    @RequestMapping("adminPage")
    public String viewPlate_Mgr(Model model){
        model.addAttribute("postList",postService.findAll());
        model.addAttribute("plateList",plateService.findAll());
        return "adminPage";
    }
}
