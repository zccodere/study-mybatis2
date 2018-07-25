package com.zccoder.mybatis2.ch3.annotation.mapper;

import com.zccoder.mybatis2.ch3.annotation.model.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 标题：角色表 Mapper<br>
 * 描述：角色表 Mapper<br>
 * 时间：2018/06/09<br>
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
    SysRole selectById(Long id);

    /**
     * 通过ID查询角色
     *
     * @param id 角色ID
     * @return 角色
     */
    @Results(id = "baseResultMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time"),
    })
    @Select({"select id,role_name,enabled,create_by,create_time from sys_role where id = #{id}"})
    SysRole selectById2(Long id);

    /**
     * 查询全部
     * @return 角色列表
     */
    @ResultMap("baseResultMap")
    @Select("select id,role_name roleName,enabled,create_by createBy,create_time createTime from sys_role")
    List<SysRole> selectAll();

    /**
     * 新增角色
     * @param sysRole 角色
     */
    @Insert({"insert into sys_role(id,role_name,enabled,create_by,create_time) " +
            "values(#{id},#{roleName},#{enabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})"})
    void insert(SysRole sysRole);

    /**
     * 新增角色-返回自增主键
     * @param sysRole 角色
     */
    @Insert({"insert into sys_role(role_name,enabled,create_by,create_time) " +
            "values(#{roleName},#{enabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})"})
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert2(SysRole sysRole);

    /**
     * 新增角色-返回非自增主键
     * @param sysRole 角色
     */
    @Insert({"insert into sys_role(role_name,enabled,create_by,create_time) " +
            "values(#{roleName},#{enabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})"})
    @SelectKey(statement = "select last_insert_id()",keyProperty = "id",resultType = Long.class,before = false)
    void insert3(SysRole sysRole);

    /**
     * 修改角色
     * @param sysRole 角色
     */
    @Update({"update sys_role set role_name = #{roleName},enabled=#{enabled},create_by=#{createBy},create_time=#{createTime,jdbcType=TIMESTAMP} where id = #{id}"})
    void updateById(SysRole sysRole);

    /**
     * 删除角色
     * @param id 角色ID
     */
    @Delete("delete from sys_role where id = #{id}")
    void deleteById(Long id);

}
