package com.zccoder.mybatis2.ch9.spring.model;

import java.io.Serializable;

/**
 * 标题：字典表<br>
 * 描述：字典表<br>
 * 时间：2018/06/27<br>
 *
 * @author zc
 **/
public class SysDict implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String code;
    private String name;
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}