package com.msj.service.impl;

import com.msj.entity.DataList;
import com.msj.entity.Type;
import com.msj.mapper.GoodMapper;
import com.msj.mapper.TypeMapper;
import com.msj.service.DataListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/18 22:23
 */
@Service(value = "dataList")
public class DataListServiceImpl implements DataListService {
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private GoodMapper goodMapper;


    @Override
    public List<DataList> getAll() {
        List<DataList> dataLists = new ArrayList<>();
        List<Type> typeList = typeMapper.getAll();
        for (Type type : typeList) {
            DataList dataList = new DataList();
            dataList.setType(type);
            dataList.setGoodList(goodMapper.findByTypeId(type.getId()));
            dataLists.add(dataList);
        }
        return dataLists;

    }
}
