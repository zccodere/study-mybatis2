package com.zccoder.mybatis2.ch3.annotation.model;

import java.io.Serializable;

/**
 * 标题：权限表<br>
 * 描述：权限表<br>
 * 时间：2018/05/30<br>
 *
 * @author zc
 **/
public class SysPrivilege implements Serializable {

    private static final long serialVersionUID = 6302564024711121343L;
    /**
     * 权限ID
     */
    private Long id;
    /**
     * 权限名称
     */
    private String privilegeName;
    /**
     * 权限URL
     */
    private String privilegeUrl;

    @Override
    public String toString() {
        return "SysPrivilege{" +
                "id=" + id +
                ", privilegeName='" + privilegeName + '\'' +
                ", privilegeUrl='" + privilegeUrl + '\'' +
                '}';
    }

    /**
     * 获取 权限ID
     *
     * @return id 权限ID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * 设置 权限ID
     *
     * @param id 权限ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 权限名称
     *
     * @return privilegeName 权限名称
     */
    public String getPrivilegeName() {
        return this.privilegeName;
    }

    /**
     * 设置 权限名称
     *
     * @param privilegeName 权限名称
     */
    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    /**
     * 获取 权限URL
     *
     * @return privilegeUrl 权限URL
     */
    public String getPrivilegeUrl() {
        return this.privilegeUrl;
    }

    /**
     * 设置 权限URL
     *
     * @param privilegeUrl 权限URL
     */
    public void setPrivilegeUrl(String privilegeUrl) {
        this.privilegeUrl = privilegeUrl;
    }
}
