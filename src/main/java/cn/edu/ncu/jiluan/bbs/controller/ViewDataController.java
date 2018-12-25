package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.service.PlateService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;

@Controller
public class ViewDataController {
    @Autowired
    private PlateService plateService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String viewPlatePost(Model model){
        model.addAttribute("plateList",plateService.findAll());
        model.addAttribute("plateInfoList",plateService.getPlateAyalysisInfoList());
        return "dataAnalysis";
    }
}
