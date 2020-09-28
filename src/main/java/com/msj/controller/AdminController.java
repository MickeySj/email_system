package com.msj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/27 19:36
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("msg", "成功");
        return "admin/index";
    }
}
