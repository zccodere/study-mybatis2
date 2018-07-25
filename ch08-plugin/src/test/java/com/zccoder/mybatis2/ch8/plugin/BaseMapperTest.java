package com.zccoder.mybatis2.ch8.plugin;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

import java.io.IOException;
import java.io.Reader;

/**
 * 标题：测试基类<br>
 * 描述：测试基类<br>
 * 时间：2018/06/26<br>
 *
 * @author zc
 **/
public class BaseMapperTest {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init()throws Exception{
        Reader reader = Resources.getResourceAsReader("mybatis.cfg.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
    }

    protected SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

}
