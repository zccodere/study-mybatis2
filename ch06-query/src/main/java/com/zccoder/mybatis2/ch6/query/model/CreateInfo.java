package com.zccoder.mybatis2.ch6.query.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 标题：创建信息<br>
 * 描述：创建信息<br>
 * 时间：2018/06/21<br>
 *
 * @author zc
 **/
public class CreateInfo implements Serializable{

    private static final long serialVersionUID = 1156992009011398445L;

    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;

    @Override
    public String toString() {
        return "CreateInfo{" +
                "createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    /**
     * 获取 创建人
     *
     * @return createBy 创建人
     */
    public String getCreateBy() {
        return this.createBy;
    }

    /**
     * 设置 创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
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
