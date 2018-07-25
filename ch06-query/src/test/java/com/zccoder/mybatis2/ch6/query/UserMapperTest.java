package com.zccoder.mybatis2.ch6.query;

import com.zccoder.mybatis2.ch6.query.mapper.UserMapper;
import com.zccoder.mybatis2.ch6.query.model.SysPrivilege;
import com.zccoder.mybatis2.ch6.query.model.SysRole;
import com.zccoder.mybatis2.ch6.query.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 标题：测试类<br>
 * 描述：测试类<br>
 * 时间：2018/06/20<br>
 *
 * @author zc
 **/
public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectUserAndRoleById(){
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
       // 用户ID只能有一个角色ID
        SysUser user = userMapper.selectUserAndRoleById(1001L);

        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getRole());

        sqlSession.close();
    }

    @Test
    public void testSelectUserAndRoleById2(){
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 用户ID只能有一个角色ID
        SysUser user = userMapper.selectUserAndRoleById2(1001L);

        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getRole());

        sqlSession.close();
    }

    @Test
    public void testSelectUserAndRoleByIdSelect(){
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 用户ID只能有一个角色ID
        SysUser user = userMapper.selectUserAndRoleByIdSelect(1001L);

        Assert.assertNotNull(user);
        user.equals(null);
        Assert.assertNotNull(user.getRole());

        sqlSession.close();
    }

    @Test
    public void testSelectAllUserAndRoles(){
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<SysUser> userList = userMapper.selectAllUserAndRoles();

        Assert.assertNotNull(userList);
        for (SysUser user : userList) {
            System.out.println("用户名：" + user.getUserName());
            for (SysRole role : user.getRoleList()) {
                System.out.println("角色名："+role.getRoleName());
                for (SysPrivilege privilege : role.getPrivilegeList()) {
                    System.out.println("权限名："+privilege.getPrivilegeName());
                }
            }
        }

        sqlSession.close();
    }

    @Test
    public void testSelectAllUserAndRolesSelect(){
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        SysUser user = userMapper.selectAllUserAndRolesSelect(1L);
        Assert.assertNotNull(user);
        System.out.println("用户名：" + user.getUserName());
        for (SysRole role : user.getRoleList()) {
            System.out.println("角色名："+role.getRoleName());
            for (SysPrivilege privilege : role.getPrivilegeList()) {
                System.out.println("权限名："+privilege.getPrivilegeName());
            }
        }

        sqlSession.close();
    }

    @Test
    public void testSelectUserById(){
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        SysUser user = new SysUser();
        user.setId(1L);
        userMapper.selectUserById(user);
        Assert.assertNotNull(user.getUserName());
        System.out.println("用户名：" + user.getUserName());

        sqlSession.close();
    }

    @Test
    public void testSelectUserPage(){
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> params = new HashMap<>();
        params.put("userName","ad");
        params.put("offset",0);
        params.put("limit",10);
        List<SysUser> userList = userMapper.selectUserPage(params);
        Long total = (Long) params.get("total");
        System.out.println("总数：" + total);
        for (SysUser user : userList) {
            System.out.println("用户名：" + user.getUserName());
        }

        sqlSession.close();
    }

    @Test
    public void testInsertUserAndRoles(){
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        SysUser user = new SysUser();
        user.setUserName("test1");
        user.setUserPassword("123456");
        user.setUserEmail("test@zccoder.com");
        user.setUserInfo("test info");
        user.setHeadImg(new byte[]{1,2,3});
        // 插入用户信息和角色关联信息
        userMapper.insertUserAndRoles(user,"1,2");
        Assert.assertNotNull(user.getId());
        Assert.assertNotNull(user.getCreateTime());

        // 测试删除刚刚插入的数据
        userMapper.deleteUserById(user.getId());
        sqlSession.close();
    }
}
