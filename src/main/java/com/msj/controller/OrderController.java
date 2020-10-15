package com.msj.controller;

import com.msj.config.MyException;
import com.msj.entity.Order;
import com.msj.entity.User;
import com.msj.service.ItemService;
import com.msj.service.OrderService;
import com.msj.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/20 17:59
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ItemService itemService;

    private static final int CARTCOUNT = 0;


    /*获取所有订单*/
    @RequestMapping("/getAll")
    public String getAll(Model model) {
        List<Order> orderList = orderService.getAll();
        model.addAttribute("orderList", orderList);
        return "index/order";
    }

    /*生成订单*/
    @RequestMapping("/orderSave")
    public String orderSave(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int pk = orderService.insert(user);
        Order order = orderService.findById(pk);
        order.setItemList(itemService.getByOrderId(pk));
        model.addAttribute("order", order);
        /*清空购物车 置空session*/
        session.setAttribute("cartCount", CARTCOUNT);
        return "index/pay";
    }

    /*订单支付*/
    @RequestMapping("/orderPay")
    public String orderPay(Order order, Model model) throws MyException {
        int flag = orderService.update(order);
        if (flag == -1) {
            model.addAttribute("msg", "库存不足");
            return "index/error";
        }
        return "index/payok";
    }

    /* 后台管理 */

    /*订单列表*/
    @RequestMapping("/orderList")
    public String orderList(Model model, @RequestParam(name = "current", required = false, defaultValue = "1") int current) {
        PageUtils PageUtils = new PageUtils();
        PageUtils.setCurrent(current);
        PageUtils.setRecordTotal(orderService.getRecordTotal());
        model.addAttribute("orderList", orderService.getAllLimit(PageUtils.getCurrent(), PageUtils.getPageSize()));
        model.addAttribute("page", PageUtils);
        model.addAttribute("url", "/order/orderList");
        return "admin/order_list";
    }

    @RequestMapping("/status")
    public String status(Model model, @RequestParam("status") int status, @RequestParam(name = "current", required = false, defaultValue = "1") int current) {
        PageUtils PageUtils = new PageUtils();
        PageUtils.setCurrent(current);
        PageUtils.setRecordTotal(orderService.getRecordTotal());
        return "";
    }
}

