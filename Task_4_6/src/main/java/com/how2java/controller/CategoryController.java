package com.how2java.controller;


import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import com.how2java.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// 告诉spring mvc这是一个控制器类
@Controller
public class CategoryController {

    @Autowired
//  自动装配
    CategoryMapper categoryMapper;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getAll(Model model){
//      获取所有优秀学生信息,存放在cs中
        List<Category> cs=categoryMapper.getAll();
//      获取每个专业学生人数
        List<Student> s=categoryMapper.getPp();
        int a=0;
        for (Student student : s) {
//          遍历每个专业学生人数并相加
            a=a+student.getPp_number();
        }
//      传入人数a
        model.addAttribute("s",a);
//      传入容器cs
        model.addAttribute("cs",cs);
        return "index";
    }

    @RequestMapping(value="/profession",method = RequestMethod.GET)
    public String goM(){
        return "profession";
    }


}


/**
 * @Controller 控制器
 * @RequestMapping("/") 请求映射
 * ModelAndView  模型和视图
 * @Autowired  自动装配
 */