package com.zccoder.mybatis2.ch6.query.type;

/**
 * 标题：使用自定义的类型处理器<br>
 * 描述：使用自定义的类型处理器<br>
 * 时间：2018/06/22<br>
 *
 * @author zc
 **/
public enum EnabledType {

    /**
     * 启用
     */
    enabled(1),
    /**
     * 禁用
     */
    disabled(0);

    private final int value;

    EnabledType(int value){
        this.value = value;
    }
    public  int getValue(){
        return value;
    }
}
