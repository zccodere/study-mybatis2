package com.zccoder.mybatis2.ch8.plugin.mapper;

import com.zccoder.mybatis2.ch8.plugin.model.SysRole;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 标题：角色表 Mapper<br>
 * 描述：角色表 Mapper<br>
 * 时间：2018/06/26<br>
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
    @Results(id = "baseResultMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time"),
    })
    @Select({"select id,role_name,enabled,create_by,create_time from sys_role where id = #{id}"})
    SysRole selectById(Long id);

    /**
     * 查询全部
     * @return 角色列表
     */
    @ResultMap("baseResultMap")
    @Select("select * from sys_role")
    List<SysRole> selectAll();

    /**
     * 分页查询
     * @param rowBounds 分页参数
     * @return 角色列表
     */
    List<SysRole> selectAll(RowBounds rowBounds);

}
