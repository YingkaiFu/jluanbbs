package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GetPostsByPlateIdController {
    @Autowired
    private PlateService plateService;



    @RequestMapping(value = "/plate/{plateId}",method = RequestMethod.GET)
    public String findPostEntitiesByPlateId(@PathVariable Integer plateId, Model model){
        model.addAttribute("postList",plateService.findPostEntitiesByPlateId(plateId));
        model.addAttribute("plateList",plateService.findAll());
        model.addAttribute("plate",plateService.findPlateEntityByPlateId(plateId));
        return "plateInfo";
    }

    @RequestMapping(value = "/postMgr/{plateId}",method = RequestMethod.GET)
    public String findPostEntitiesByPlateId_Mgr(@PathVariable Integer plateId, Model model){
        model.addAttribute("postList",plateService.findPostEntitiesByPlateId(plateId));
        model.addAttribute("plateList",plateService.findAll());
        model.addAttribute("plate",plateService.findPlateEntityByPlateId(plateId));
        return "postMgr";
    }
}