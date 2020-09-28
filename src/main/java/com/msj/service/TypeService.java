package com.msj.service;

import com.msj.entity.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/17 23:13
 */
public interface TypeService {
    List<Type> getAll();

    Type findById(@Param("id") int id);

    Type findByName(@Param("name") String name);

    int insert(Type type);

    int delete(@Param("id") int id);

    int update(Type type);
}
