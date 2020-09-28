package com.msj.service.impl;

import com.msj.entity.Good;
import com.msj.mapper.GoodMapper;
import com.msj.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/18 0:18
 */
@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodMapper mapper;

    @Override
    public List<Good> getAll() {
        return mapper.getAll();
    }

    @Override
    public int getAllCount() {
        return mapper.getAll().size();
    }

    @Override
    public List<Good> getAllLimit(int current, int pageSize) {
        return mapper.getAllLimit((current - 1) * pageSize, pageSize);
    }

    @Override
    public Good findById(int id) {
        return mapper.findById(id);
    }

    @Override
    public Good findByName(String name) {
        return mapper.findByName(name);
    }

    @Override
    public List<Good> findBySearch(String name) {
        return mapper.findBySearch(name);
    }

    @Override
    public int findBySearchCount(String name) {
        return mapper.findBySearch(name).size();
    }


    @Override
    public List<Good> findBySearchLimit(String name, int current, int pageSize) {
        return mapper.findBySearchLimit(name, (current - 1) * pageSize, pageSize);
    }

    @Override
    public List<Good> findByTypeId(int typeId) {
        return mapper.findByTypeId(typeId);
    }

    @Override
    public int findByTypeIdCount(int typeId) {
        return mapper.findByTypeId(typeId).size();
    }


    @Override
    public List<Good> findByTypeIdLimit(int typeId, int current, int pageSize) {
        return mapper.findByTypeIdLimit(typeId, (current - 1) * pageSize, pageSize);
    }

    @Override
    public int insert(Good good) {
        return mapper.insert(good);
    }

    @Override
    public int delete(int id) {
        return mapper.delete(id);
    }

    @Override
    public int update(Good good) {
        return mapper.update(good);
    }
}
