package com.zccoder.mybatis2.ch6.query.mapper;

import com.zccoder.mybatis2.ch6.query.model.SysPrivilege;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 标题：权限表 Mapper<br>
 * 描述：权限表 Mapper<br>
 * 时间：2018/06/21<br>
 *
 * @author zc
 **/
public interface PrivilegeMapper {
    /**
     * 通过角色ID查询权限列表
     * @param roleId 角色ID
     * @return 权限列表
     */
    List<SysPrivilege> selectPrivilegeByRoleId(@Param("roleId")Long roleId);
    
}
