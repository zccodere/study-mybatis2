package com.zccoder.mybatis2.ch6.query.mapper;


import com.zccoder.mybatis2.ch6.query.model.Country;

import java.util.List;
import java.util.Map;

/**
 * 标题：表 country Mapper<br>
 * 描述：表 country Mapper<br>
 * 时间：2018/06/22<br>
 *
 * @author zc
 **/
public interface CountryMapper {
    /**
     * 查询全部
     * @return 全部信息
     */
    List<Country> listAll();

    /**
     * 执行Oracle中的存储过程
     * @param params 入数
     * @return 出参
     */
    Object selectCountries(Map<String,Object> params);
}
