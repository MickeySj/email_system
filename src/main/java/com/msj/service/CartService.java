package com.msj.service;

import com.msj.entity.Cart;
import com.msj.entity.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/19 16:29
 */
public interface CartService {
    List<Cart> getAll(@Param("userId") int userId);

    Cart findById(@Param("id") int id);

    Integer getCartTotal(@Param("userId") int userId);

    Integer getRecordsTotal(@Param("userId") int userId);

    Integer getGoodTotal(@Param("userId") int userId);

    String insert(Cart cart);

    int delete(@Param("id") int id);

    int deleteByUserId(@Param("userId") int userId);

    int update(Cart cart);
}
