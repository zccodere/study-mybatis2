package com.zccoder.mybatis2.ch10.boot.model;

import java.io.Serializable;

/**
 * 标题：表 country PO<br>
 * 描述：表 country PO<br>
 * 时间：2018/07/03<br>
 *
 * @author zc
 **/
public class Country implements Serializable {

    private static final long serialVersionUID = -7360153715392794454L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 国家名称
     */
    private String countryname;
    /**
     * 国家代码
     */
    private String countrycode;

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryname='" + countryname + '\'' +
                ", countrycode='" + countrycode + '\'' +
                '}';
    }

    /**
     * 获取 主键
     *
     * @return id 主键
     */
    public Long getId() {
        return this.id;
    }

    /**
     * 设置 主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 国家名称
     *
     * @return countryname 国家名称
     */
    public String getCountryname() {
        return this.countryname;
    }

    /**
     * 设置 国家名称
     *
     * @param countryname 国家名称
     */
    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    /**
     * 获取 国家代码
     *
     * @return countrycode 国家代码
     */
    public String getCountrycode() {
        return this.countrycode;
    }

    /**
     * 设置 国家代码
     *
     * @param countrycode 国家代码
     */
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }
}
