package com.msj.controller;

import com.msj.entity.Admin;
import com.msj.entity.User;
import com.msj.service.AdminService;
import com.msj.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/27 19:36
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/index")
    public String index() {
        return "redirect:/admin/login";
    }

    @RequestMapping("/login")
    public String login(Admin admin, Model model, HttpServletRequest request) {
        String msg = "登陆成功";
        if (admin.getUsername() != null) {
            Admin oAdmin = adminService.findByName(admin.getUsername());
            if (oAdmin != null && MD5Utils.md5Password(admin.getPassword()).equals(oAdmin.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("admin", oAdmin);
                request.setAttribute("msg", "登陆成功");
                return "admin/index";
            }
        }
        msg = "登录失败";
        request.setAttribute("msg", msg);
        return "admin/login";
    }

    @RequestMapping("/adminList")
    public String adminList(Model model) {
        model.addAttribute("adminList", adminService.getAll());
        return "admin/admin_list";
    }

    /*添加管理员*/
    @RequestMapping("/adminAdd")
    public String adminAdd() {
        return "admin/admin_add";
    }

    @RequestMapping("/adminSave")
    public String adminSave(Admin admin) {
        admin.setPassword(MD5Utils.md5Password(admin.getPassword()));
        adminService.insert(admin);
        return "redirect:/admin/adminList";

    }

    /*重置密码*/
    @RequestMapping("/adminRe")
    public String adminRe(@RequestParam("id") int id) {
        return "redirect:/admin/adminList";
    }

    /*删除管理员*/
    @RequestMapping("/adminDelete")
    public String adminDelete(@RequestParam("id") int id) {
        adminService.delete(id);
        return "redirect:/admin/adminList";

    }
}
