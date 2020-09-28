package com.msj.mapper;

import com.msj.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/27 19:22
 */
public interface AdminMapper {

    List<Admin> getAll();

    Admin findById(@Param("id") int id);

    Admin findByName(@Param("username") String username);

    int insert(Admin admin);

    int delete(@Param("id") int id);

    int update(Admin admin);
}
