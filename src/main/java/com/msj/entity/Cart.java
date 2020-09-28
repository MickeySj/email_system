package com.msj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/19 16:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Integer id;
    private Integer amount;
    private Integer goodId;
    private Integer userId;
    private Integer total;
    private Integer cartTotal;
    private Good good;

}
