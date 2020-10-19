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

    List<Order> getAllLimit(@Param("current") int current, @Param("pageSize") int pageSize);

    List<Order> getAllByStatus(@Param("status") int status, @Param("current") int current, @Param("pageSize") int pageSize);

    int getRecordTotal(@Param("status") int status);

    List<Order> getByUserId(@Param("userId") int userId);

    Order findById(@Param("id") int id);

    int insert(User user);

    int delete(@Param("id") int id);

    int update(Order order) throws MyException;

    int orderSend(Order order);

    int orderFinish(Order order);
}
