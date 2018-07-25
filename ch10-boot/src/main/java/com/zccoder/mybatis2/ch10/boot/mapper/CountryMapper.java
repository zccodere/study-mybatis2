package com.zccoder.mybatis2.ch10.boot.mapper;



import com.zccoder.mybatis2.ch10.boot.model.Country;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 标题：表 country Mapper<br>
 * 描述：表 country Mapper<br>
 * 时间：2018/07/03<br>
 *
 * @author zc
 **/
@Mapper
public interface CountryMapper {
    /**
     * 查询全部
     * @return 全部信息
     */
    List<Country> listAll();
}
