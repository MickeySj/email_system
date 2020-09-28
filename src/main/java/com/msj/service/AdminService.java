package com.msj.service;

import com.msj.entity.Admin;
import com.msj.mapper.AdminMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/28 15:13
 */
public interface AdminService {

    List<Admin> getAll();

    Admin findById(@Param("id") int id);

    Admin findByName(@Param("username") String username);

    int insert(Admin admin);

    int delete(@Param("id") int id);

    int update(Admin admin);
}
