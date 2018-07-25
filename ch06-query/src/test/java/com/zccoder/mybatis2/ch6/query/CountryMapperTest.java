package com.zccoder.mybatis2.ch6.query;

import com.zccoder.mybatis2.ch6.query.mapper.CountryMapper;
import com.zccoder.mybatis2.ch6.query.model.Country;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 标题：Oracle存储过程测试<br>
 * 描述：Oracle存储过程测试<br>
 * 时间：2018/06/22<br>
 *
 * @author zc
 **/
public class CountryMapperTest extends BaseMapperTest {

    /**
     * 测试前，请确保 已经换成Oracle的JDBC驱动并修改mybatis.xfg.xml
     * 确保可以连接到Oracle数据库
     */
    @Test
    public void testSelectCountries(){
        SqlSession sqlSession = getSqlSession();
        CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
        // 获取第一页，10条内容，默认查询总数count
        Map<String,Object> params = new HashMap<>();
        countryMapper.selectCountries(params);

        List<Country> list1 = (List<Country>) params.get("list1");
        List<Country> list2 = (List<Country>) params.get("list2");

        Assert.assertNotNull(list1);
        Assert.assertNotNull(list2);

        sqlSession.close();
    }

}
