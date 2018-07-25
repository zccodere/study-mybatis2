package com.zccoder.mybatis2.ch2.xml.model;

import java.io.Serializable;

/**
 * 标题：角色权限关系表<br>
 * 描述：角色权限关系表<br>
 * 时间：2018/05/30<br>
 *
 * @author zc
 **/
public class SysRolePrivilege implements Serializable {

    private static final long serialVersionUID = 2907067824853750697L;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 权限ID
     */
    private Long privilegeId;

    @Override
    public String toString() {
        return "SysRolePrivilege{" +
                "roleId=" + roleId +
                ", privilegeId=" + privilegeId +
                '}';
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

    /**
     * 获取 权限ID
     *
     * @return privilegeId 权限ID
     */
    public Long getPrivilegeId() {
        return this.privilegeId;
    }

    /**
     * 设置 权限ID
     *
     * @param privilegeId 权限ID
     */
    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }
}
