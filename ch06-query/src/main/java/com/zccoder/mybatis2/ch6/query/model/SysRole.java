package com.zccoder.mybatis2.ch6.query.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 标题：角色表<br>
 * 描述：角色表<br>
 * 时间：2018/06/20<br>
 *
 * @author zc
 **/
public class SysRole implements Serializable{

    private static final long serialVersionUID = 335857052537245985L;
    /**
     * 角色ID
     */
    private Long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 有效标志
     */
    private Integer enabled;
    /**
     * 创建人（创建者用户ID）
     */
    private Long createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 角色包含的权限列表
     */
    private List<SysPrivilege> privilegeList;
    /**
     * 创建信息
     */
    private CreateInfo createInfo;

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", enabled=" + enabled +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", privilegeList=" + privilegeList +
                ", createInfo=" + createInfo +
                '}';
    }

    /**
     * 获取 角色ID
     *
     * @return id 角色ID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * 设置 角色ID
     *
     * @param id 角色ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 角色名称
     *
     * @return roleName 角色名称
     */
    public String getRoleName() {
        return this.roleName;
    }

    /**
     * 设置 角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取 有效标志
     *
     * @return enabled 有效标志
     */
    public Integer getEnabled() {
        return this.enabled;
    }

    /**
     * 设置 有效标志
     *
     * @param enabled 有效标志
     */
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    /**
     * 获取 创建人（创建者用户ID）
     *
     * @return createBy 创建人（创建者用户ID）
     */
    public Long getCreateBy() {
        return this.createBy;
    }

    /**
     * 设置 创建人（创建者用户ID）
     *
     * @param createBy 创建人（创建者用户ID）
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取 创建时间
     *
     * @return createTime 创建时间
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置 创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 角色包含的权限列表
     *
     * @return privilegeList 角色包含的权限列表
     */
    public List<SysPrivilege> getPrivilegeList() {
        return this.privilegeList;
    }

    /**
     * 设置 角色包含的权限列表
     *
     * @param privilegeList 角色包含的权限列表
     */
    public void setPrivilegeList(List<SysPrivilege> privilegeList) {
        this.privilegeList = privilegeList;
    }

    /**
     * 获取 创建信息
     *
     * @return createInfo 创建信息
     */
    public CreateInfo getCreateInfo() {
        return this.createInfo;
    }

    /**
     * 设置 创建信息
     *
     * @param createInfo 创建信息
     */
    public void setCreateInfo(CreateInfo createInfo) {
        this.createInfo = createInfo;
    }
}
