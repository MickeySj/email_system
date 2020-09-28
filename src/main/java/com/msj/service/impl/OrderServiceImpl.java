package com.msj.service.impl;

import com.msj.entity.Cart;
import com.msj.entity.Item;
import com.msj.entity.Order;
import com.msj.entity.User;
import com.msj.mapper.CartMapper;
import com.msj.mapper.ItemMapper;
import com.msj.mapper.OrderMapper;
import com.msj.service.OrderService;
import com.msj.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/20 18:33
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private CartMapper cartMapper;
    private static final int STATUS = 1;
    private static final int STATUS_PAYED = 2;
    private static final int PAYTYPE = 1;

    @Override
    public List<Order> getAll() {
        List<Order> orderList = orderMapper.getAll();
        for (Order order : orderList) {
            List<Item> itemList = itemMapper.getByOrderId(order.getId());
            order.setItemList(itemList);
        }
        return orderList;
    }

    @Override
    public List<Order> getByUserId(int userId) {
/*        List<Order> orderList = orderMapper.getByUserId(userId);
        for (Order order : orderList) {
            List<Item> itemList = itemMapper.getByOrderId(order.getId());
            order.setItemList(itemList);
        }*/
        return orderMapper.getByUserId(userId);
    }

    @Override
    public Order findById(int id) {
        return orderMapper.findById(id);
    }

    @Override
    public int insert(User user) {
        /*生成订单*/
        Order Norder = new Order();
        Norder.setTotal(cartMapper.getCartTotal(user.getId()));
        Norder.setAmount(cartMapper.getGoodTotal(user.getId()));
        Norder.setStatus(STATUS);
        Norder.setPaytype(PAYTYPE);
        Norder.setName(user.getName());
        Norder.setPhone(user.getPhone());
        Norder.setAddress(user.getAddress());
        Norder.setSystime(TimeUtils.getCurrentDate());
        Norder.setUserId(user.getId());
        orderMapper.insert(Norder);
        int orderPK = Norder.getId();

        /*生成订单项 将购物车商品封单独封装成每一个item 并插入到数据库中 */
        List<Cart> cartList = cartMapper.getAll(user.getId());
        for (Cart cart : cartList) {
            Item item = new Item();
            item.setPrice(cart.getGood().getPrice());
            item.setAmount(cart.getAmount());
            item.setOrderId(orderPK);
            item.setGoodId(cart.getGood().getId());
            itemMapper.insert(item);
        }
        /*清空相应的购物车*/
        cartMapper.deleteByUserId(user.getId());
        /*返回生成order(订单)的PK*/
        return orderPK;
    }

    @Override
    public int delete(int id) {
        return orderMapper.delete(id);
    }

    @Override
    public int update(Order order) {
        Order Oorder = orderMapper.findById(order.getId());
        System.out.println("Oorder=" + Oorder);
        Oorder.setStatus(STATUS_PAYED);
        Oorder.setName(order.getName() == null ? Oorder.getName() : order.getName());
        Oorder.setPhone(order.getPhone() == null ? Oorder.getPhone() : order.getPhone());
        Oorder.setAddress(order.getAddress() == null ? Oorder.getAddress() : order.getAddress());
        Oorder.setPaytype(order.getPaytype() == null ? Oorder.getPaytype() : order.getPaytype());
        System.out.println("new Oorder=" + Oorder);
        return orderMapper.update(Oorder);
    }
}
