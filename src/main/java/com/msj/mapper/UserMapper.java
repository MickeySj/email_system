package com.msj.mapper;


import com.msj.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/15 11:16
 */
public interface UserMapper {

    List<User> getAll();

    User findById(@Param("id") int id);

    User findByName(@Param("username") String username);

    int insert(User user);

    int delete(@Param("id") int id);

    int update(User user);

}
