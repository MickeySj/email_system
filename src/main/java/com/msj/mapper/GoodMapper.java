package com.msj.mapper;

import com.msj.entity.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/17 23:49
 */
public interface GoodMapper {
    List<Good> getAll();

    List<Good> getAllLimit(@Param("current") int current, @Param("pageSize") int pageSize);

    List<Good> getNewGoodLimit(@Param("current") int current, @Param("pageSize") int pageSize);

    List<Good> getTopListLimit(@Param("current") int current, @Param("pageSize") int pageSize);

    Good findById(@Param("id") int id);

    Good findByName(@Param("name") String name);

    List<Good> findBySearch(@Param("name") String name);

    List<Good> findBySearchLimit(@Param("name") String name, @Param("current") int current, @Param("pageSize") int pageSize);

    List<Good> findByTypeId(@Param("typeId") int typeId);

    List<Good> findByTypeIdLimit(@Param("typeId") int typeId, @Param("current") int current, @Param("pageSize") int pageSize);

    int insert(Good good);

    int delete(@Param("id") int id);

    int update(Good good);


}

