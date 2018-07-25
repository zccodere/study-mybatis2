package com.zccoder.mybatis2.ch7.cache;

import com.zccoder.mybatis2.ch7.cache.mapper.RoleMapper;
import com.zccoder.mybatis2.ch7.cache.mapper.UserMapper;
import com.zccoder.mybatis2.ch7.cache.model.SysRole;
import com.zccoder.mybatis2.ch7.cache.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

/**
 * 标题：缓存测试<br>
 * 描述：缓存测试<br>
 * 时间：2018/06/25<br>
 *
 * @author zc
 **/
public class CacheTest extends BaseMapperTest {

    /**
     * MyBatis默认开启一级缓存
     * 一级缓存只存在于SqlSession 的生命周期中
     * 任何的INSERT、UPDATE、DELETE操作都会清空一级缓存
     */
    @Test
    public void testL1Cache(){
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 查询id=1的用户
        SysUser user = userMapper.selectById(1L);
        user.setUserName("New name");
        // 再次查询id=1的用户
        SysUser user1 = userMapper.selectById(1L);
        // 虽然没有更新数据库，但是这个用户名和user1重新赋值的用户名相同
        Assert.assertEquals("New name",user1.getUserName());
        // user1和user2都是同一个实例
        Assert.assertEquals(user,user1);

        sqlSession.close();

        System.out.println("开启新的sqlSession");
        // 开始另一个新的SqlSession
        sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 查询id=1的用户
        SysUser user2 = mapper.selectById(1L);
        Assert.assertNotEquals("New name",user2.getUserName());
        Assert.assertNotEquals(user,user2);
        // 执行删除操作
        mapper.deleteById(2L);
        // 获取user3
        SysUser user3 = mapper.selectById(1L);
        // 这里的user2和user3是两个不同的实例
        Assert.assertNotEquals(user2,user3);

        sqlSession.close();
    }

    @Test
    public void testL2Cache(){
        SqlSession sqlSession = getSqlSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

        SysRole role1 = roleMapper.selectById(1L);
        role1.setRoleName("New Name");
        SysRole role2 = roleMapper.selectById(1L);
        // 虽然没有更新数据库，但是这个用户名和role1重新赋值的用户名相同
        Assert.assertEquals("New Name",role2.getRoleName());
        // role1 和 role2 都是同一个实例
        Assert.assertEquals(role1,role2);

        sqlSession.close();

        System.out.println("开启新的SqlSession");

        sqlSession = getSqlSession();
        RoleMapper roleMapper2 = sqlSession.getMapper(RoleMapper.class);
        SysRole role3 = roleMapper2.selectById(1L);
        Assert.assertEquals("New Name",role3.getRoleName());
        SysRole role4 = roleMapper2.selectById(1L);
        // role3 和 role4 是两个不同的实例
        Assert.assertNotEquals(role3,role4);

        sqlSession.close();
    }

}
