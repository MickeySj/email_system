package com.msj.controller;

import com.msj.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/28 15:39
 */
@Controller
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @ModelAttribute
    public void typeListDF(Model model) {
        model.addAttribute("type", typeService.getAll());
    }

    @RequestMapping("/typeList")
    public void typeList() {
    }
}
