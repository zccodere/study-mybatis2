package com.zccoder.mybatis2.ch9.spring.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 标题：首页Controller<br>
 * 描述：首页Controller<br>
 * 时间：2018/06/27<br>
 *
 * @author zc
 **/
@Controller
public class IndexController {
    
    @RequestMapping(value = {"", "/index"})
    public ModelAndView dicts() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("now", new Date());
        return mv;
    }
}
