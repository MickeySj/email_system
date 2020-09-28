package com.msj.service.impl;

import com.msj.entity.Item;
import com.msj.mapper.ItemMapper;
import com.msj.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/20 17:56
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper mapper;

    @Override
    public List<Item> getAll() {
        return mapper.getAll();
    }

    @Override
    public List<Item> getByOrderId(int orderId) {
        return mapper.getByOrderId(orderId);
    }

    @Override
    public Item findById(int id) {
        return mapper.findById(id);
    }

    @Override
    public int insert(Item item) {
        return mapper.insert(item);
    }

    @Override
    public int delete(int id) {
        return mapper.delete(id);
    }

    @Override
    public int update(Item item) {
        return mapper.update(item);
    }
}
