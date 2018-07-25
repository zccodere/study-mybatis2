package com.zccoder.mybatis2.ch4.dynamic.mapper;

import com.zccoder.mybatis2.ch4.dynamic.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 标题：用户表 Mapper<br>
 * 描述：用户表 Mapper<br>
 * 时间：2018/06/14<br>
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
     * 根据动态条件查询用户信息
     * @param sysUser 用户
     * @return 用户信息
     */
    List<SysUser> selectByUser(SysUser sysUser);

    /**
     * 根据主键动态更新
     * @param sysUser 用户
     */
    void updateByIdSelective(SysUser sysUser);

    /**
     * 新增用户-使用useGeneratedKeys方式
     * @param sysUser 用户
     */
    void insert2(SysUser sysUser);

    /**
     * 根据用户ID或用户名查询
     * @param sysUser 用户
     * @return 用户信息
     */
    SysUser selectByIdOrUserName(SysUser sysUser);

    /**
     * 根据用户ID集合查询
     * @param idList 用户ID集合
     * @return 用户信息集合
     */
    List<SysUser> selectByIdList(@Param("idList") List<Long> idList);

    /**
     * 批量插入用户信息
     * @param userList 用户集合
     */
    void insertList(@Param("userList") List<SysUser> userList);

    /**
     * 通过 Map 更新列
     * @param map Map集合
     */
    void updateByMap(@Param("map") Map<String,Object> map);

}
