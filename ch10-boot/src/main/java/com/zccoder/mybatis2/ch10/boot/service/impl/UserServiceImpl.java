package com.zccoder.mybatis2.ch10.boot.service.impl;

import java.util.List;

import com.zccoder.mybatis2.ch10.boot.service.UserService;
import com.zccoder.mybatis2.ch2.xml.mapper.UserMapper;
import com.zccoder.mybatis2.ch2.xml.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 标题：用户服务实现<br>
 * 描述：用户服务实现<br>
 * 时间：2018/07/03<br>
 *
 * @author zc
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public SysUser findById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<SysUser> findAll() {
        return userMapper.selectAll();
    }

}
