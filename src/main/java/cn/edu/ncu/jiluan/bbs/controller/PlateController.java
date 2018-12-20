package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.entity.PlateEntity;
import cn.edu.ncu.jiluan.bbs.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "plate")
public class PlateController {
    @Autowired
    private PlateService service;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<PlateEntity> findAll(){
        return service.findAll();
    }
}
