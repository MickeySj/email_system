package com.msj.controller;

import com.msj.entity.Good;
import com.msj.mapper.TopMapper;
import com.msj.service.GoodService;
import com.msj.service.TopService;
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
    private TopService topService;
    @Autowired
    private GoodService goodService;

    @ModelAttribute
    public void todayList(Model model) {
        List<Good> todayList = topService.getTodayList();
        model.addAttribute("todayList", todayList);
    }

    @RequestMapping("/detail")
    public String detail(Model model, @RequestParam("id") int id) {
        Good good = goodService.findById(id);
        model.addAttribute("good", good);
        return "index/detail";
    }

    /* 商品清单 */
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

    /* 商品增加 */
    @RequestMapping("/goodAdd")
    public String goodAdd() {
        return "admin/good_add.jsp";
    }

    @RequestMapping("/goodSave")
    public String goodSave() {
        return "admin/good_list";
    }

}