package com.msj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/20 17:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Integer id;
    private Integer price;
    private Integer amount;
    private Integer orderId;
    private Integer goodId;
    private Good good;
}
