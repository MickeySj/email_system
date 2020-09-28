package com.msj.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

//HttPMessageConverter:消息转换器 --> 数据类型转换
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String str) {
        if (str != null && !"".equals(str)) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
