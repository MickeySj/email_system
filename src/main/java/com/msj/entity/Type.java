package com.msj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/17 22:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type {
    private Integer id;
    private String name;
    private Integer num;
}
