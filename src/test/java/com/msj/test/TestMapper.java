package com.msj.test;

import com.msj.entity.Cart;
import com.msj.entity.Good;
import com.msj.entity.Order;
import com.msj.mapper.*;
import com.msj.service.CartService;
import com.msj.service.DataListService;
import com.msj.service.OrderService;
import com.msj.util.MD5Utils;
import com.msj.util.TimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/15 12:30
 */
/*配置运行环境*/
@RunWith(SpringJUnit4ClassRunner.class)
/*加载配置文件*/
@ContextConfiguration({"classpath:spring-mybatis.xml", "classpath:spring-mvc.xml"})
public class TestMapper {
    @Autowired
    GoodMapper goodMapper;
    @Autowired
    TopMapper topMapper;

    @Test
    public void getAllClasses() {
        List<Good> goodList = goodMapper.getAllLimit(1, 10);
        for (Good good : goodList) {
            if(good.getTop().getType()==null)
            {
                System.out.println(good);
            }
        }
    }

    @Test
    public void md5() {
        System.out.println(DigestUtils.md5Digest("嘻嘻".getBytes()));
        System.out.println(MD5Utils.md5Password("嘻嘻"));

    }
}