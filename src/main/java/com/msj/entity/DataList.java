package com.msj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/18 22:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataList {
    private Type type;
    private List<Good> goodList;
}
