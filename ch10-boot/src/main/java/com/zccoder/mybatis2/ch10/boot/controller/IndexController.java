package com.zccoder.mybatis2.ch10.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 标题：首页Controller<br>
 * 描述：首页Controller<br>
 * 时间：2018/06/28<br>
 *
 * @author zc
 **/
@RestController
public class IndexController {

    @RequestMapping("/")
    String home(){
        return "Hello World";
    }

}
