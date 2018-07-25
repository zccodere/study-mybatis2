package com.zccoder.mybatis2.ch7.cache.mapper;

import com.zccoder.mybatis2.ch7.cache.model.SysUser;

import java.util.List;

/**
 * 标题：用户表 Mapper<br>
 * 描述：用户表 Mapper<br>
 * 时间：2018/06/25<br>
 *
 * @author zc
 **/
public interface UserMapper {
    /**
     * 获取一个用户信息通过用户ID
     * @param id 用户ID
     * @return 用户信息
     */
    SysUser selectById(Long id);

    /**
     * 获取全部用户
     * @return 用户列表
     */
    List<SysUser> selectAll();
    /**
     * 新增用户
     * @param sysUser 用户
     */
    void insert(SysUser sysUser);

    /**
     * 新增用户-使用useGeneratedKeys方式
     * @param sysUser 用户
     */
    void insert2(SysUser sysUser);

    /**
     * 新增用户-使用selectKey方式
     * @param sysUser 用户
     */
    void insert3(SysUser sysUser);

    /**
     * 根据主键更新
     * @param sysUser 用户
     */
    void updateById(SysUser sysUser);

    /**
     * 根据主键删除
     * @param userId 用户ID
     */
    void deleteById(Long userId);

}
