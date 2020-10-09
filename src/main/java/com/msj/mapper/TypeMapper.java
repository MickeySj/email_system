package com.msj.mapper;

import com.msj.entity.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/17 22:55
 */
public interface TypeMapper {
    /*根据num值 从小到大(允许负数) 进行排序*/
    List<Type> getAll();

    Type findById(@Param("id") int id);

    Type findByName(@Param("name") String name);

    int insert(Type type);

    int delete(@Param("id") int id);

    int update(Type type);
}
