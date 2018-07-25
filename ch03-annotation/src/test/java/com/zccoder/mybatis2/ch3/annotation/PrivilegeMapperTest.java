package com.zccoder.mybatis2.ch3.annotation;

import com.zccoder.mybatis2.ch3.annotation.mapper.PrivilegeMapper;
import com.zccoder.mybatis2.ch3.annotation.mapper.RoleMapper;
import com.zccoder.mybatis2.ch3.annotation.model.SysPrivilege;
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
public class PrivilegeMapperTest extends BaseMapperTest{

    @Test
    public void testSelectById(){
        SqlSession sqlSession = getSqlSession();
        PrivilegeMapper privilegeMapper = (PrivilegeMapper)sqlSession.getMapper(PrivilegeMapper.class);
        SysPrivilege sysPrivilege = privilegeMapper.selectById(1L);
        Assert.assertNotNull(sysPrivilege);
        sqlSession.close();
    }

}
