package com.msj.mapper;

import com.msj.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/20 18:15
 */
public interface OrderMapper {
    List<Order> getAll();

    List<Order> getByUserId(@Param("userId") int userId);

    Order findById(@Param("id") int id);

    /*插入返回主键值*/
    int insert(Order order);

    int delete(@Param("id") int id);

    int update(Order order);
}
