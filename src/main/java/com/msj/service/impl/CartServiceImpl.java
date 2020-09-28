package com.msj.service.impl;

import com.msj.entity.Cart;
import com.msj.mapper.CartMapper;
import com.msj.service.CartService;
import javafx.beans.binding.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/19 16:29
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;


    @Override
    public List<Cart> getAll(int userId) {
        return cartMapper.getAll(userId);
    }

    @Override
    public Cart findById(int id) {
        return cartMapper.findById(id);
    }

    @Override
    public Integer getCartTotal(int userId) {
        return cartMapper.getCartTotal(userId);
    }

    @Override
    public Integer getRecordsTotal(int userId) {
        return cartMapper.getRecordsTotal(userId);
    }

    @Override
    public Integer getGoodTotal(int userId) {
        return cartMapper.getGoodTotal(userId);
    }


    @Override
    public String insert(Cart cart) {

        /*购物车商品已存在的情况 直接将对应商品的数量加一 返回exist*/
        List<Cart> cartList = cartMapper.getAll(cart.getUserId());
        Integer goodId = cart.getGoodId();
        for (Cart oCart : cartList) {
            if (oCart.getGoodId().equals(goodId)) {
                oCart.setAmount(cart.getAmount() + 1);
                cartMapper.update(oCart);
                return "1";
            }
        }
        /*购物车中商品不存在的情况 返回插入状态*/
        int i = cartMapper.insert(cart);
        if (i > 0) {
            return "1";
        }
        return "2";
    }

    @Override
    public int delete(int id) {
        return cartMapper.delete(id);
    }

    @Override
    public int deleteByUserId(int userId) {
        return cartMapper.deleteByUserId(userId);
    }

    @Override
    public int update(Cart cart) {
        return cartMapper.update(cart);
    }
}
