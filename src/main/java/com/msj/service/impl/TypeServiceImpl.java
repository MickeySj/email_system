package com.msj.service.impl;

import com.msj.entity.Type;
import com.msj.mapper.TypeMapper;
import com.msj.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/17 23:14
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper mapper;

    @Override
    public List<Type> getAll() {
        return mapper.getAll();
    }

    @Override
    public Type findById(int id) {
        return mapper.findById(id);
    }

    @Override
    public Type findByName(String name) {
        return mapper.findByName(name);
    }

    @Override
    public int insert(Type type) {
        return mapper.insert(type);
    }

    @Override
    public int delete(int id) {
        return mapper.delete(id);
    }

    @Override
    public int update(Type type) {
        return mapper.update(type);
    }
}
