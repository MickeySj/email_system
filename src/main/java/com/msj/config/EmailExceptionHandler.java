package com.msj.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author sj
 * @version 1.0
 * @date 2020/10/13 19:29
 * @desc spring mvc 总异常处理器
 */
@ControllerAdvice
public class EmailExceptionHandler {

    @ExceptionHandler(MyException.class)
    public String error(Model model, MyException myException) {
        model.addAttribute("msg", myException.getMessage());
        return "index/error";
    }

    @ExceptionHandler(Exception.class)
    public String error(Model model) {
        model.addAttribute("msg", "系统错误");
        return "index/error";
    }
}
