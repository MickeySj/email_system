package com.msj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/18 9:23
 * @desc 推荐表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Top {
    private Integer id;
    private Integer goodId;
    private Integer type;
}
