package com.msj.service;

import com.msj.config.MyException;
import com.msj.entity.Order;
import com.msj.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/20 18:32
 */
public interface OrderService {
    List<Order> getAll();

    List<Order> getByUserId(@Param("userId") int userId);

    Order findById(@Param("id") int id);

    int insert(User user);

    int delete(@Param("id") int id);

    int update(Order order) throws MyException;
}
