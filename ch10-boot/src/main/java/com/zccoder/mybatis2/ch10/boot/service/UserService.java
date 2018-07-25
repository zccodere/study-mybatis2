package com.zccoder.mybatis2.ch10.boot.service;

import com.zccoder.mybatis2.ch2.xml.model.SysUser;

import java.util.List;

/**
 * 标题：用户服务<br>
 * 描述：用户服务<br>
 * 时间：2018/07/03<br>
 *
 * @author zc
 **/
public interface UserService {

    /**
     * 通过 id 查询用户
     *
     * @param id ID
     * @return 用户信息
     */
    SysUser findById(Long id);

    /**
     * 查询全部用户
     *
     * @return 用户集合
     */
    List<SysUser> findAll();
}
