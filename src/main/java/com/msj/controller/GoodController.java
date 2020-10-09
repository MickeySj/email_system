package com.msj.controller;

import com.msj.entity.Good;
import com.msj.mapper.TopMapper;
import com.msj.service.GoodService;
import com.msj.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/18 10:16
 */
@Controller
@RequestMapping("/goods")
public class GoodController {
    @Autowired
    private TopMapper topMapper;
    @Autowired
    private GoodService goodService;

    @ModelAttribute
    public void todayList(Model model) {
        List<Good> todayList = topMapper.getTodayList();
        model.addAttribute("todayList", todayList);
    }

    @RequestMapping("/detail")
    public String detail(Model model, @RequestParam("id") int id) {
        Good good = goodService.findById(id);
        model.addAttribute("good", good);
        return "index/detail";
    }

    @RequestMapping("/goodList")
    public String goodList(Model model, @RequestParam(name = "current", required = false, defaultValue = "1") int current) {
        PageUtils goodPageUtils = new PageUtils();
        goodPageUtils.setCurrent(current);
        goodPageUtils.setRecordTotal(goodService.getAllCount());
        List<Good> goodList = goodService.getAllLimit(goodPageUtils.getCurrent(), goodPageUtils.getPageSize());
        model.addAttribute("goodList", goodList);
//        model.addAttribute("flag", 3);
//        model.addAttribute("type", 0);
        model.addAttribute("page", goodPageUtils);
        model.addAttribute("url", "/goods/goodList");
        return "admin/good_list";
    }

    @RequestMapping("/topList")
    public String topList(Model model, @RequestParam(name = "current", required = false, defaultValue = "1") int current) {
        
        return "admin/good_list";
    }
}