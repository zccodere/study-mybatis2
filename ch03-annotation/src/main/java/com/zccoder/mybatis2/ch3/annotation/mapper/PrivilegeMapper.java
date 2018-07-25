package com.zccoder.mybatis2.ch3.annotation.mapper;

import com.zccoder.mybatis2.ch3.annotation.model.SysPrivilege;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * 标题：权限表 Mapper<br>
 * 描述：权限表 Mapper<br>
 * 时间：2018/06/09<br>
 *
 * @author zc
 **/
public interface PrivilegeMapper {

    /**
     * 查询权限-权限ID
     * @param id 权限ID
     * @return 权限
     */
    @SelectProvider(type = PrivilegeProvider.class,method = "selectById")
    SysPrivilege selectById(Long id);

}
