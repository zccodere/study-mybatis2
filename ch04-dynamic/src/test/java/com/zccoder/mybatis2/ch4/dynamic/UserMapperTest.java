package com.zccoder.mybatis2.ch4.dynamic;

import com.zccoder.mybatis2.ch4.dynamic.mapper.UserMapper;
import com.zccoder.mybatis2.ch4.dynamic.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 标题：测试类<br>
 * 描述：测试类<br>
 * 时间：2018/06/14<br>
 *
 * @author zc
 **/
public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() throws Exception {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
        // 只查询用户名时
        SysUser user = new SysUser();
        user.setUserName("ad");
        List<SysUser> userList = userMapper.selectByUser(user);
        Assert.assertTrue(userList.size() > 0);
        // 只查询用户邮箱时
        user = new SysUser();
        user.setUserEmail("test@zccoder.com");
        userList = userMapper.selectByUser(user);
        Assert.assertTrue(userList.size() > 0);
        // 同时查询用户名和邮箱时
        user = new SysUser();
        user.setUserName("ad");
        user.setUserEmail("test@zccoder.com");
        userList = userMapper.selectByUser(user);
        // 由于没有同时符合这两个条件的用户，因此查询结果为0
        Assert.assertTrue(userList.size() == 0);

        sqlSession.close();
    }

    @Test
    public void testUpdateByIdSelective() throws Exception{
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);

        SysUser user = new SysUser();
        user.setId(1L);
        user.setUserEmail("test@zccoder.com");
        userMapper.updateByIdSelective(user);

        user = userMapper.selectById(1L);
        Assert.assertEquals("admin",user.getUserName());
        Assert.assertEquals("test@zccoder.com",user.getUserEmail());

        sqlSession.close();
    }

    @Test
    public void testInsert2Seclective(){
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
        // 创建一个user对象
        SysUser user = new SysUser();
        user.setUserName("test-selective");
        user.setUserPassword("123456");
        user.setUserInfo("test info");
        user.setCreateTime(new Date());
        // 插入数据库
        userMapper.insert2(user);
        // 获取插入的这条数据
        user = userMapper.selectById(user.getId());
        Assert.assertEquals("test@zccoder.com",user.getUserEmail());

        sqlSession.close();
    }

    @Test
    public void testSelectByIdOrUserName(){
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 只查询用户名时
        SysUser query = new SysUser();
        query.setId(1L);
        query.setUserName("admin");
        SysUser user = userMapper.selectByIdOrUserName(query);
        Assert.assertNotNull(user);
        // 当没有id时
        query.setId(null);
        user = userMapper.selectByIdOrUserName(query);
        Assert.assertNotNull(user);
        // 当id和name都为空时
        query.setUserName(null);
        user = userMapper.selectByIdOrUserName(query);
        Assert.assertNull(user);

        sqlSession.close();
    }

    @Test
    public void testSelectByIdList(){
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Long> idList = new ArrayList<>();
        idList.add(1L);
        idList.add(1001L);
        // 业务逻辑中必须校验idList.size() > 0
        List<SysUser> userList = userMapper.selectByIdList(idList);
        Assert.assertEquals(2,userList.size());

        sqlSession.close();
    }


    @Test
    public void testInsertUserList(){
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<SysUser> userList = new ArrayList<>();
        SysUser user;
        for (int i = 0; i < 2; i++) {
            user = new SysUser();
            user.setUserName("test" + i);
            user.setUserPassword("123456");
            user.setUserEmail("test@zccoder.com");
            userList.add(user);
        }
        userMapper.insertList(userList);
        for (SysUser userTemp : userList) {
            System.out.println(userTemp.getId());
        }
        sqlSession.close();
    }

    @Test
    public void testUpdateByMap(){
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();

        // 查询条件，同样也是更新字段，必须保证该值存在
        map.put("id",1L);
        // 更新其它字段
        map.put("user_email","test@zccoder.com");
        map.put("user_password","12345678");
        map.put("id",1L);
        userMapper.updateByMap(map);

        SysUser user = userMapper.selectById(1L);
        Assert.assertEquals("test@zccoder.com",user.getUserEmail());

        sqlSession.close();
    }

}
