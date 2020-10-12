package com.msj.service;

import com.msj.entity.Good;
import com.msj.entity.Top;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/18 10:18
 */
public interface TopService {
    List<Top> getAll();

    List<Good> getTodayList();

    List<Good> getTodayListLimit(@Param("current") int current, @Param("pageSize") int pageSize);

    int getRecordsTotal();

    Top findById(@Param("id") int id);

    int insert(Top top);

    int delete(@Param("id") int id);

    int deleteByGoodAndType(@Param("goodId") int goodId, @Param("type") int type);

    int update(Top top);
}
