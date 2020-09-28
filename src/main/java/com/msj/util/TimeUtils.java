package com.msj.util;

import org.springframework.aop.support.AopUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author sj
 * @version 1.0
 * @date 2020/8/26 21:41
 */

public class TimeUtils {
    public static String getCurrentDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());
        return time;
    }

    public static void main(String[] args) {
        System.out.println(TimeUtils.getCurrentDate());
    }
}
