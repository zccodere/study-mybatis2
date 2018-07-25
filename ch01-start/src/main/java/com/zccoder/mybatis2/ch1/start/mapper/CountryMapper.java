package com.zccoder.mybatis2.ch1.start.mapper;

import com.zccoder.mybatis2.ch1.start.model.Country;

import java.util.List;

/**
 * 标题：表 country Mapper<br>
 * 描述：表 country Mapper<br>
 * 时间：2018/05/29<br>
 *
 * @author zc
 **/
public interface CountryMapper {
    /**
     * 查询全部
     * @return 全部信息
     */
    List<Country> listAll();
}
