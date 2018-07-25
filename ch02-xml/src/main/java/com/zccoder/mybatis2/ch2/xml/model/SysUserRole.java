package com.zccoder.mybatis2.ch2.xml.model;

import java.io.Serializable;

/**
 * 标题：用户角色关系表<br>
 * 描述：用户角色关系表<br>
 * 时间：2018/05/30<br>
 *
 * @author zc
 **/
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 6703158731555824449L;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 角色ID
     */
    private Long roleId;

    @Override
    public String toString() {
        return "SysUserRole{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }

    /**
     * 获取 用户ID
     *
     * @return userId 用户ID
     */
    public Long getUserId() {
        return this.userId;
    }

    /**
     * 设置 用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 角色ID
     *
     * @return roleId 角色ID
     */
    public Long getRoleId() {
        return this.roleId;
    }

    /**
     * 设置 角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
