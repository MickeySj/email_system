package com.msj.mapper;

import com.msj.entity.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/19 16:13
 */
public interface CartMapper {
    List<Cart> getAll(@Param("userId") int userId);

    Cart findById(@Param("id") int id);

    /*购物车总价格*/
    Integer getCartTotal(@Param("userId") int userId);

    /*购物车商品数量*/
    Integer getRecordsTotal(@Param("userId") int userId);

    /*购物车商品总数量*/
    Integer getGoodTotal(@Param("userId") int userId);

    int insert(Cart cart);

    int delete(@Param("id") int id);

    int deleteByUserId(@Param("userId") int userId);

    int update(Cart cart);
}
