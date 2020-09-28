package com.msj.controller;

import com.msj.entity.Good;
import com.msj.mapper.TopMapper;
import com.msj.service.GoodService;
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

}