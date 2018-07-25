package com.zccoder.mybatis2.ch6.query.mapper;

import com.zccoder.mybatis2.ch6.query.model.SysRole;
import com.zccoder.mybatis2.ch6.query.model.SysRoleType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 标题：角色表 Mapper<br>
 * 描述：角色表 Mapper<br>
 * 时间：2018/06/20<br>
 *
 * @author zc
 **/
public interface RoleMapper {

    /**
     * 通过ID查询角色
     *
     * @param id 角色ID
     * @return 角色
     */
    @Select({"select id,role_name roleName,enabled,create_by createBy,create_time createTime from sys_role where id = #{id}"})
    SysRoleType selectById(Long id);
    /**
     * 修改角色
     * @param sysRole 角色
     */
    @Update({"update sys_role set role_name = #{roleName},enabled=#{enabled},create_by=#{createBy},create_time=#{createTime,jdbcType=TIMESTAMP} where id = #{id}"})
    void updateById(SysRoleType sysRole);

    /**
     * 查询角色信息
     * @param id 角色ID
     * @return 角色信息
     */
    SysRole selectRoleById(Long id);

    /**
     * 查询全部角色和权限
     * @return 角色和权限列表
     */
    List<SysRole> selectAllRoleAndPrivileges();

    /**
     * 通过用户ID查询角色信息
     * @param userId 用户ID
     * @return 角色列表
     */
    List<SysRole> selectRoleByUserId(@Param("userId") Long userId);

    /**
     * 根据用户ID获取用户的角色信息
     * @param userId 用户ID
     * @return 角色列表
     */
    List<SysRole> selectRoleByUserIdChoose(Long userId);
}
