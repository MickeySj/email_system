package com.msj.service.impl;

import com.msj.entity.Admin;
import com.msj.mapper.AdminMapper;
import com.msj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/28 15:15
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> getAll() {
        return adminMapper.getAll();
    }

    @Override
    public Admin findById(int id) {
        return adminMapper.findById(id);
    }

    @Override
    public Admin findByName(String username) {
        return adminMapper.findByName(username);
    }

    @Override
    public int insert(Admin admin) {
        return adminMapper.insert(admin);
    }

    @Override
    public int delete(int id) {
        return adminMapper.delete(id);
    }

    @Override
    public int update(Admin admin) {
        return adminMapper.update(admin);
    }
}
