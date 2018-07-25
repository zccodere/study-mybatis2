package com.zccoder.mybatis2.ch6.query.mapper;

import com.zccoder.mybatis2.ch6.query.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 标题：用户表 Mapper<br>
 * 描述：用户表 Mapper<br>
 * 时间：2018/06/20<br>
 *
 * @author zc
 **/
public interface UserMapper {

    /**
     * 根据用户id获取用户信息和用户的角色信息
     * @param id 用户ID
     * @return 用户信息
     */
    SysUser selectUserAndRoleById(Long id);

    /**
     * 根据用户id获取用户信息和用户的角色信息
     * @param id 用户ID
     * @return 用户信息
     */
    SysUser selectUserAndRoleById2(Long id);

    /**
     * 根据用户id获取用户信息和用户的角色信息
     * @param id 用户ID
     * @return 用户信息
     */
    SysUser selectUserAndRoleByIdSelect(Long id);

    /**
     * 获取所有的用户以及对应的所有角色
     * @return 用户级角色信息列表
     */
    List<SysUser> selectAllUserAndRoles();

    /**
     * 通过嵌套查询获取指定用户的信息以及用户的角色和权限信息
     * @param id 用户ID
     * @return 用户信息
     */
    SysUser selectAllUserAndRolesSelect(Long id);

    /**
     * 使用存储过程查询用户信息
     * @param user
     */
    void selectUserById(SysUser user);

    /**
     * 使用存储过程分页查询
     * @param params userName/pageNum/pageSize/total
     * @return 用户集合
     */
    List<SysUser> selectUserPage(Map<String,Object> params);

    /**
     * 使用存储过程保存用户信息和角色关联信息
     * @param user 用户信息
     * @param roleIds 角色ID集合（多个ID之间用英文逗号分隔）
     */
    void insertUserAndRoles(@Param("user")SysUser user,@Param("roleIds")String roleIds);

    /**
     * 根据用户ID删除用户和用户的角色信息
     * @param id 用户ID
     */
    void deleteUserById(Long id);
}
