package com.zccoder.mybatis2.ch8.plugin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 标题：角色表<br>
 * 描述：角色表<br>
 * 时间：2018/06/26<br>
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

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", enabled=" + enabled +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
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
}
