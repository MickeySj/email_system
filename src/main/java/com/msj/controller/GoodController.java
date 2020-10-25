package com.msj.controller;

import com.msj.entity.Good;
import com.msj.mapper.TopMapper;
import com.msj.service.GoodService;
import com.msj.service.TopService;
import com.msj.service.TypeService;
import com.msj.util.ImgLoadUtils;
import com.msj.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
    @Autowired
    private TypeService typeService;

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
    public String goodAdd(Model model) {
        model.addAttribute("typeList", typeService.getAll());
        return "admin/good_add";
    }

    @RequestMapping("/goodSave")
    public String goodSave(Good good, int typeId, MultipartFile file, HttpServletRequest request) throws IOException {
/*        System.out.println(file);
        System.out.println(good);
        System.out.println(typeId);*/
        String src = ImgLoadUtils.upLoad(request, file);
        good.setCover(src);
        good.setSales(0);
        good.setType(typeService.findById(typeId));
        int insert = goodService.insert(good);
        return "redirect:/goods/goodList";
    }

    /* 商品修改 */
    @RequestMapping("/goodEdit")
    public String goodEdit(@RequestParam("id") int id, Model model) {
        System.out.println("id=" + id);
        model.addAttribute("good", goodService.findById(id));
        model.addAttribute("typeList", typeService.getAll());
        return "admin/good_edit";
    }

    @RequestMapping("/goodUpdate")
    public String goodUpdate(Good good, int typeId, MultipartFile file, HttpServletRequest request) throws IOException {
        String src = ImgLoadUtils.upLoad(request, file) != null ? ImgLoadUtils.upLoad(request, file) : good.getCover();
        good.setCover(src);
        good.setType(typeService.findById(typeId));
        goodService.update(good);
        System.out.println("good=" + good);
        return "redirect:/goods/goodList";
    }

    /* 商品删除 */
    @RequestMapping("/goodDelete")
    public String goodDelete(@RequestParam("id") int id) {
        goodService.delete(id);
        return "redirect:/goods/goodList";
    }
}