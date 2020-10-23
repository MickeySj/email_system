package com.msj.controller;

import com.msj.entity.User;
import com.msj.service.CartService;
import com.msj.service.UserService;
import com.msj.service.impl.UserServiceImpl;
import com.msj.util.MD5Utils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/15 12:45
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private CartService cartService;

    @RequestMapping("/getAll")
    public String getAll() {
        return service.getAll().toString();
    }

    @RequestMapping("/register")
    public String register(Model model, User user) {
        if (user != null) {
            if (service.findByName(user.getUsername()) != null) {
                model.addAttribute("msg", "用户名已存在");
                return "index/register";
            }
            user.setPassword(MD5Utils.md5Password(user.getPassword()));
            int flag = service.insert(user);
        }
        model.addAttribute("msg", "注册成功,请登录");
        return "index/login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, User user) {
        String msg = "登陆成功";
        if (!user.getUsername().equals("") && !user.getPassword().equals("")) {
            User oUser = service.findByName(user.getUsername());
            if (oUser != null && MD5Utils.md5Password(user.getPassword()).equals(oUser.getPassword())) {
                int cartCount = cartService.getRecordsTotal(oUser.getId());

                HttpSession session = request.getSession();
                session.setAttribute("user", oUser);
                session.setAttribute("cartCount", cartCount);
                return "redirect:/index/index";
            }
        }
        msg = "登录失败";
        request.setAttribute("msg", msg);
        return "forward:/index/login";
    }

    @RequestMapping("/address")
    public String address() {
        return "index/address";
    }

    @RequestMapping("/password")
    public String password() {
        return "index/password";
    }

    //    更新地址 并且在session中重写
    @RequestMapping("/addressUpdate")
    public String addressUpdate(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        User nUser = (User) session.getAttribute("user");
        nUser.setName(user.getName());
        nUser.setPhone(user.getPhone());
        nUser.setAddress(user.getAddress());
        service.update(nUser);
        session.setAttribute("user", nUser);
        request.setAttribute("msg", "保存成功");
        return "index/address";
    }

    //        修改密码 并在session中重新写入
    @RequestMapping("/passwordUpdate")
    public String passwordUpdate(HttpServletRequest request, @RequestParam("password") String password, @RequestParam("passwordNew") String passwordNew) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (MD5Utils.md5Password(password).equals(user.getPassword())) {
            user.setPassword(MD5Utils.md5Password(passwordNew));
            service.update(user);
            session.setAttribute("user", user);
            request.setAttribute("msg", "修改成功");
            return "index/password";
        }
        request.setAttribute("msg", "修改失败");
        return "index/password";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("cartCount");
        return "redirect:/index/index";
    }

    /* 后台对于用户账户的管理 */
    @RequestMapping("/userList")
    public String userList(Model model) {
        model.addAttribute("userList", service.getAll());
        return "admin/user_list";
    }

    /* 用户添加 */
    @RequestMapping("/userAdd")
    public String userAdd() {
        return "admin/user_add";
    }

    @RequestMapping("/userSave")
    public String userSave(User user, Model model) {
        if (user != null) {
            if (service.findByName(user.getUsername()) != null) {
                model.addAttribute("msg", "用户已存在");
                return "admin/user_add";
            }
            user.setPassword(MD5Utils.md5Password(user.getPassword()));
            int flag = service.insert(user);
        }
        model.addAttribute("msg", "用户添加成功");
        return "admin/user_add";
    }

    /*用户密码重置*/
    @RequestMapping("/userRe")
    public String userRe(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", service.findById(id));
        return "admin/user_reset";
    }

    @RequestMapping("/userReset")
    public String userReset(User user, Model model) {
        user.setPassword(MD5Utils.md5Password(user.getPassword()));
        service.updatePassWord(user);
        model.addAttribute("user", service.findById(user.getId()));
        model.addAttribute("msg", "用户密码成功重置");
        return "admin/user_reset";
    }

    /* 用户修改 */
    @RequestMapping("/userEdit")
    public String userEdit(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", service.findById(id));
        return "admin/user_edit";
    }

    @RequestMapping("/userUpdate")
    public String userUpdate(User user, Model model) {
        user.setPassword(service.findById(user.getId()).getPassword());
        service.update(user);
        model.addAttribute("msg", "用户信息修改成功");
        model.addAttribute("admin", service.findById(user.getId()));
        return "admin/user_edit";
    }

    /*删除*/
    @RequestMapping("/userDelete")
    public String userDelete(@RequestParam("id") int id) {
        service.delete(id);
        return "redirect:/user/userList";
    }
}
