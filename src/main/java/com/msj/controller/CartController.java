package com.msj.controller;

import com.msj.entity.Cart;
import com.msj.entity.User;
import com.msj.service.CartService;
import com.msj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/19 16:32
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;
    private static final int AMOUNT = 1;

    //    获取购物车信息
    @RequestMapping("getAll")
    public String getAll(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
//        System.out.println("userID=" + user.getId());
        List<Cart> cartList = cartService.getAll(user.getId());
        model.addAttribute("cartList", cartList);
        model.addAttribute("cartTotal", cartService.getCartTotal(user.getId()));
        return "index/cart";
    }

    //    获取购物车商品数量 并在session中重新写入
    @RequestMapping("getRecordsTotal")
    @ResponseBody
    public String getRecordsTotal(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int recordsTotal = cartService.getRecordsTotal(user.getId());
        request.getSession().setAttribute("cartCount", recordsTotal);
        return String.valueOf(recordsTotal);
    }


    //添加至购物车
    @RequestMapping("/cartBuy")
    @ResponseBody
    public String cartBuy(HttpServletRequest request, HttpServletResponse response, @RequestParam("goodId") int goodId) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Cart cart = new Cart();
        cart.setAmount(AMOUNT);
        cart.setGoodId(goodId);
        cart.setUserId(user.getId());
        String flag = cartService.insert(cart);
        return flag;
    }

    //购物车中商品购买数量的添加
    @RequestMapping("/cartAdd")
    @ResponseBody
    public String cartAdd(@RequestParam("id") int id) {
        Cart cart = cartService.findById(id);
        cart.setAmount(cart.getAmount() + 1);
        int flag = cartService.update(cart);
        System.out.println("cart=" + cartService.findById(id));
        return String.valueOf(flag);
    }

    //购物车中商品购买数量的减少
    @RequestMapping("/cartLess")
    @ResponseBody
    public String cartLess(@RequestParam("id") int id) {
        Cart cart = cartService.findById(id);
        cart.setAmount(cart.getAmount() - 1);
        int flag = cartService.update(cart);
        System.out.println("cart=" + cartService.findById(id));
        return String.valueOf(flag);
    }

    //购物车中商品删除
    @RequestMapping("/cartDelete")
    @ResponseBody
    public String cartDelete(HttpServletRequest request, @RequestParam("id") int id) {
        Cart cart = cartService.findById(id);
        int flag = cartService.delete(id);
        int cartCount = cartService.getRecordsTotal(cart.getUserId());
        HttpSession session = request.getSession();
        session.setAttribute("cartCount", cartCount);
        return String.valueOf(flag);
    }

    //商品总价
    @RequestMapping("/cartTotal")
    @ResponseBody
    public String cartTotal(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int cartTotal = cartService.getCartTotal(user.getId());
        return String.valueOf(cartTotal);
    }


}
