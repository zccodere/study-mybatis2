package com.zccoder.mybatis2.ch3.annotation;

import com.zccoder.mybatis2.ch3.annotation.mapper.RoleMapper;
import com.zccoder.mybatis2.ch3.annotation.model.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * 标题：角色Mapper测试类<br>
 * 描述：角色Mapper测试类<br>
 * 时间：2018/06/09<br>
 *
 * @author zc
 **/
public class RoleMapperTest extends BaseMapperTest{

    @Test
    public void testSelectById(){
        SqlSession sqlSession = getSqlSession();
        RoleMapper roleMapper = (RoleMapper)sqlSession.getMapper(RoleMapper.class);
        SysRole role = roleMapper.selectById(1L);
        Assert.assertNotNull(role);
        sqlSession.close();
    }

    @Test
    public void testSelectById2(){
        SqlSession sqlSession = getSqlSession();

        RoleMapper roleMapper = (RoleMapper)sqlSession.getMapper(RoleMapper.class);
        SysRole role = roleMapper.selectById2(1L);
        Assert.assertNotNull(role);
        sqlSession.close();
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = getSqlSession();

        RoleMapper roleMapper = (RoleMapper)sqlSession.getMapper(RoleMapper.class);
        List<SysRole> role = roleMapper.selectAll();
        Assert.assertNotNull(role);
        Assert.assertTrue(role.size() > 0);
        sqlSession.close();
    }

}
