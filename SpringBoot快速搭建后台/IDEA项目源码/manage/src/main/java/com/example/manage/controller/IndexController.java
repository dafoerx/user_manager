package com.example.manage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * FileName:    IndexController
 * Author:      Yuan-Programmer
 * Date:        2021/12/4 14:27
 * Description:
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/index") // 访问路径
    public ModelAndView toIndex() {
        // 返回templates目录下index.html
        ModelAndView view = new ModelAndView("index");
        return view;
    }
}
