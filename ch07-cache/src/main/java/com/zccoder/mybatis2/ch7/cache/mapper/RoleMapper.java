package com.zccoder.mybatis2.ch7.cache.mapper;

import com.zccoder.mybatis2.ch7.cache.model.SysRole;
import org.apache.ibatis.annotations.CacheNamespaceRef;

/**
 * 标题：角色表 Mapper<br>
 * 描述：角色表 Mapper<br>
 * 时间：2018/06/25<br>
 *
 * @author zc
 **/
@CacheNamespaceRef(RoleMapper.class)
public interface RoleMapper {

    /**
     * 通过ID查询角色信息
     * @param roleId 角色ID
     * @return 角色信息
     */
    SysRole selectById(long roleId);
}
