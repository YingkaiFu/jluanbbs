package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.entity.PlateEntity;
import cn.edu.ncu.jiluan.bbs.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<PlateEntity> findAll(){
        return plateService.findAll();
    }

    @RequestMapping(value = "/plateDel/{plateId}",method = RequestMethod.GET)
    public void deletePlateEntityByPlateId(@PathVariable Integer plateId){
        plateService.deletePlateEntityByPlateId(plateId);
    }
}
