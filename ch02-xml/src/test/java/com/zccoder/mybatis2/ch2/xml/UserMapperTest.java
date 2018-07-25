package com.zccoder.mybatis2.ch2.xml;

import com.zccoder.mybatis2.ch2.xml.mapper.UserMapper;
import com.zccoder.mybatis2.ch2.xml.model.SysRole;
import com.zccoder.mybatis2.ch2.xml.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * 标题：测试类<br>
 * 描述：测试类<br>
 * 时间：2018/06/06<br>
 *
 * @author zc
 **/
public class UserMapperTest extends BaseMapperTest{

    @Test
    public void testSelectById(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = userMapper.selectById(1L);
            Assert.assertNotNull(sysUser);
            Assert.assertEquals("admin",sysUser.getUserName());
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> userList = userMapper.selectAll();
            Assert.assertNotNull(userList);
            Assert.assertTrue(userList.size() > 0);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserId(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> roleList = userMapper.selectRolesByUserId(1L);
            Assert.assertNotNull(roleList);
            Assert.assertTrue(roleList.size() > 0);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsert(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setId(123L);
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("123456@qq.com");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1,2,3});
            user.setCreateTime(new Date());
            userMapper.insert(user);

            // 需要手动提交事务
//            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsert2(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("123456@qq.com");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1,2,3});
            user.setCreateTime(new Date());
            userMapper.insert2(user);

            System.out.println(user.getId());
            // 需要手动提交事务
//            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateById(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1L);
            Assert.assertNotNull(user);
            Assert.assertEquals("admin",user.getUserName());

            user.setUserEmail("test@qq.com");
            userMapper.updateById(user);
            // 需要手动提交事务
//            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testDeleteById(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.deleteById(1L);
            // 需要手动提交事务
//            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void testSelectRolesByUserIdAndRoleEnabledDeleteById(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> roleList = userMapper.selectRolesByUserIdAndRoleEnabled(1L,1);
            Assert.assertNotNull(roleList);
            Assert.assertTrue(roleList.size() > 0);
        }finally {
            sqlSession.close();
        }
    }

}
