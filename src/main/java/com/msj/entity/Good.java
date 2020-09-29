package com.msj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/17 23:45
 * @desc 商品表 一对多
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Good {
    private Integer id;
    private String cover;
    private String name;
    private String intro;
    private String spec;
    private Integer price;
    private Integer stock;
    private Integer sales;
    private String content;
    private Type type;
    private Top top;
}
