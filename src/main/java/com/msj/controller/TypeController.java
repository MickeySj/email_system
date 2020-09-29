package com.msj.controller;

import com.msj.entity.Admin;
import com.msj.entity.Type;
import com.msj.service.TypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/28 15:39
 */
@Controller
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;


    @RequestMapping("/typeList")
    public String typeList(Model model) {
        model.addAttribute("typeList", typeService.getAll());
        return "admin/type_list";
    }

    /*类型修改模块*/
    @RequestMapping("/typeEdit")
    public String typeEdit(@Param("id") int id, Model model) {
        System.out.println("typeService.findById(id)="+typeService.findById(id));
        model.addAttribute("type", typeService.findById(id));
        return "admin/type_edit";
    }

    @RequestMapping("/typeUpdate")
    public String typeUpdate(Type type, Model model) {
        System.out.println("type=" + type);
        typeService.update(type);
        model.addAttribute("type", typeService.findById(type.getId()));
        model.addAttribute("msg", "修改成功");
        return "admin/type_edit";
    }

    /*类型添加模块*/
    @RequestMapping("/typeAdd")
    public String typeAdd(Model model) {
        return "admin/admin_add";
    }
}
