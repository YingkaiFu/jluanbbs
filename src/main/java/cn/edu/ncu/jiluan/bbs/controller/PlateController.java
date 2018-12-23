package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.entity.PlateEntity;
import cn.edu.ncu.jiluan.bbs.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping(value = "plate")
public class PlateController {
    @Autowired
    private PlateService plateService;

    @RequestMapping(value = "/plateMgr",method = RequestMethod.GET)
    public String findAll(Model model){
        model.addAttribute("plateList",plateService.findAll());
        return "plateMgr";
    }

    @RequestMapping(value = "/plateDel/{plateId}",method = RequestMethod.GET)
    public void deletePlateEntityByPlateId(@PathVariable Integer plateId){
        plateService.deletePlateEntityByPlateId(plateId);
    }


    @RequestMapping("/add")
    public String add(PlateEntity plateEntity) {
        plateService.savePlate(plateEntity);
        return "plateMgr";
    }



}
