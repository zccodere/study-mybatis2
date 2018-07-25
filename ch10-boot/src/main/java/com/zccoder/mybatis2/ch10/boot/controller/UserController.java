package com.zccoder.mybatis2.ch10.boot.controller;

import java.util.List;

import com.zccoder.mybatis2.ch10.boot.service.UserService;
import com.zccoder.mybatis2.ch2.xml.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 标题：用户Controller<br>
 * 描述：用户Controller<br>
 * 时间：2018/07/03<br>
 *
 * @author zc
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("users/{id}")
    SysUser user(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @RequestMapping("users")
    List<SysUser> users() {
        return userService.findAll();
    }
}
