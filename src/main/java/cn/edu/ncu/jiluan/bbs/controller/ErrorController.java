package cn.edu.ncu.jiluan.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by krito on 2018/12/26
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping
    public String getErrorPath() {
        return "home";
    }


}
