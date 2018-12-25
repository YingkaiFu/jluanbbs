package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.service.PlateService;
import cn.edu.ncu.jiluan.bbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlateController {
    @Autowired
    private PlateService plateService;

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/plate/{plateId}/{page}", method = RequestMethod.GET)
    public String findPostEntitiesByPlateId(@PathVariable Integer plateId, @PathVariable Integer page, Model model) {
        //model.addAttribute("postList",plateService.findPostEntitiesByPlateId(plateId, page, 10));
        if (plateId == 9)
            model.addAttribute("postList", postService.findAllOrderByLastReplyDesc(page, 10));
        else
            model.addAttribute("postList", postService.findAllByPlateIdOrderByIsPickedDesc(plateId, page, 10));
        model.addAttribute("plateList", plateService.findAll());
        model.addAttribute("plate", plateService.findPlateEntityByPlateId(plateId));
        return "fragments/plateInfo";
    }
}
