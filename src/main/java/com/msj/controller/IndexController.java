package com.msj.controller;

import com.msj.entity.DataList;
import com.msj.entity.Good;
import com.msj.entity.Type;
import com.msj.service.DataListService;
import com.msj.service.GoodService;
import com.msj.service.TopService;
import com.msj.service.TypeService;
import com.msj.util.PageUtils;
import org.apache.ibatis.annotations.Param;
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
 * @date 2020/9/17 16:44
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private TopService topService;
    @Autowired
    private DataListService dataListService;

    @ModelAttribute
    public void typeList(Model model) {
        List<Type> typeList = typeService.getAll();
        model.addAttribute("typeList", typeList);
    }

    @ModelAttribute
    public void todayList(Model model) {
        List<Good> todayList = topService.getTodayList();
        model.addAttribute("todayList", todayList);
    }

    @ModelAttribute
    public void hotList(Model model) {
        List<Good> hotList = goodService.getAll();
        model.addAttribute("hotList", hotList);
    }

    @ModelAttribute
    public void dataList(Model model) {
        List<DataList> dataList = dataListService.getAll();
        model.addAttribute("dataList", dataList);
    }

    @RequestMapping("/index")
    public String index() {
        return "index/index";
    }

    @RequestMapping("/login")
    public String login() {
        return "index/login";
    }

    @RequestMapping("/register")
    public String register() {
        return "index/register";
    }

    @RequestMapping("/cart")
    public String cart() {
        return "redirect:/cart/getAll";
    }

    @RequestMapping("/order")
    public String order() {
        return "redirect:/order/getAll";
    }

    @RequestMapping("/address")
    public String address() {
        return "redirect:/user/address";
    }

    @RequestMapping("/password")
    public String password() {
        return "redirect:/user/password";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "redirect:/user/logout";
    }


    @RequestMapping("/today")
    public String todayTop(Model model, @RequestParam(name = "current", required = false, defaultValue = "1") int current) {
//        List<Good> todayList = topService.getTodayList();
        PageUtils goodPageUtils = new PageUtils();
        goodPageUtils.setCurrent(current);
        goodPageUtils.setRecordTotal(topService.getRecordsTotal());
        System.out.println("topService.getRecordsTotal()=" + topService.getRecordsTotal());
        List<Good> todayList = topService.getTodayListLimit(goodPageUtils.getCurrent(), goodPageUtils.getPageSize());
        model.addAttribute("goodList", todayList);
        model.addAttribute("flag", 2);
        model.addAttribute("page", goodPageUtils);
        model.addAttribute("url", "/index/today");
        return "index/goods";
    }

    @RequestMapping("/hot")
    public String hotGoods(Model model, @RequestParam(name = "current", required = false, defaultValue = "1") int current) {
//        List<Good> goodList = goodService.getAll();
        PageUtils goodPageUtils = new PageUtils();
        goodPageUtils.setCurrent(current);
        goodPageUtils.setRecordTotal(goodService.getAllCount());
        List<Good> goodList = goodService.getAllLimit(goodPageUtils.getCurrent(), goodPageUtils.getPageSize());
        model.addAttribute("goodList", goodList);
        model.addAttribute("flag", 3);
        model.addAttribute("page", goodPageUtils);
        model.addAttribute("url", "/index/hot");
        return "index/goods";
    }

    @RequestMapping("type")
    public String type(Model model, @Param("id") int id, @RequestParam(name = "current", required = false, defaultValue = "1") int current) {
        Type type = typeService.findById(id);
//        List<Good> goodList = goodService.findByTypeId(id);
        PageUtils goodPageUtils = new PageUtils();
        goodPageUtils.setCurrent(current);
        goodPageUtils.setRecordTotal(goodService.findByTypeIdCount(id));
        List<Good> goodList = goodService.findByTypeIdLimit(id, goodPageUtils.getCurrent(), goodPageUtils.getPageSize());

        model.addAttribute("type", type);
        model.addAttribute("goodList", goodList);
        model.addAttribute("page", goodPageUtils);
        model.addAttribute("url", "/index/type");
        return "index/goods";
    }

    @RequestMapping("/new")
    public String newGoods(Model model, @RequestParam(name = "current", required = false, defaultValue = "1") int current) {
        PageUtils goodPageUtils = new PageUtils();
        goodPageUtils.setCurrent(current);
        goodPageUtils.setRecordTotal(goodService.getAllCount());
        List<Good> goodList = goodService.getNewGoodLimit(goodPageUtils.getCurrent(), goodPageUtils.getPageSize());
        model.addAttribute("goodList", goodList);
        model.addAttribute("flag", 4);
        model.addAttribute("page", goodPageUtils);
        model.addAttribute("url", "/index/new");
        return "index/goods";
    }

    @RequestMapping("/search")
    public String search(Model model, @Param("search") String search) {
        List<Good> goodList = goodService.findBySearch(search);
        model.addAttribute("name", search);
        model.addAttribute("goodList", goodList);
        return "index/goods";
    }


}
