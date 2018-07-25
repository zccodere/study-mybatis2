package com.zccoder.mybatis2.ch3.annotation.mapper;

import org.apache.ibatis.jdbc.SQL;

/**
 * 标题：使用Provider注解<br>
 * 描述：使用Provider注解<br>
 * 时间：2018/06/09<br>
 *
 * @author zc
 **/
public class PrivilegeProvider {

    /**
     * 查询权限-权限ID
     * @param id 权限ID
     * @return 权限
     */
    public String selectById(final Long id) {
        return new SQL() {
            {
                SELECT("id,privilege_name,privilege_url");
                FROM("sys_privilege");
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
