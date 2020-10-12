package com.msj.service.impl;

import com.msj.entity.Good;
import com.msj.entity.Top;
import com.msj.mapper.TopMapper;
import com.msj.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/18 10:18
 */
@Service
public class TopServiceImpl implements TopService {
    @Autowired
    private TopMapper mapper;

    @Override
    public List<Top> getAll() {
        return mapper.getAll();
    }

    @Override
    public List<Good> getTodayList() {
        return mapper.getTodayList();
    }

    @Override
    public List<Good> getTodayListLimit(int current, int pageSize) {
        return mapper.getTodayListLimit((current - 1) * pageSize, pageSize);
    }

    @Override
    public int getRecordsTotal() {
        return mapper.getRecordsTotal();
    }

    @Override
    public Top findById(int id) {
        return mapper.findById(id);
    }

    @Override
    public int insert(Top top) {
        return mapper.insert(top);
    }

    @Override
    public int delete(int id) {
        return mapper.delete(id);
    }

    @Override
    public int deleteByGoodAndType(int goodId, int type) {
        return mapper.deleteByGoodAndType(goodId, type);
    }


    @Override
    public int update(Top top) {
        return mapper.update(top);
    }
}
