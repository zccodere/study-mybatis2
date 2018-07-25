package com.zccoder.mybatis2.ch6.query;

import com.zccoder.mybatis2.ch6.query.mapper.RoleMapper;
import com.zccoder.mybatis2.ch6.query.mapper.UserMapper;
import com.zccoder.mybatis2.ch6.query.model.SysPrivilege;
import com.zccoder.mybatis2.ch6.query.model.SysRole;
import com.zccoder.mybatis2.ch6.query.model.SysRoleType;
import com.zccoder.mybatis2.ch6.query.model.SysUser;
import com.zccoder.mybatis2.ch6.query.type.Enabled;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

/**
 * 标题：测试类<br>
 * 描述：测试类<br>
 * 时间：2018/06/20<br>
 *
 * @author zc
 **/
public class RoleMapperTest extends BaseMapperTest {

    @Test
    public void testSelectRoleByUserId(){
        SqlSession sqlSession = getSqlSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        for (SysRole role : roleMapper.selectRoleByUserId(1L)) {
            System.out.println("角色名："+role.getRoleName());
            for (SysPrivilege privilege : role.getPrivilegeList()) {
                System.out.println("权限名：" + privilege.getPrivilegeName());
            }
        }
        sqlSession.close();
    }
    @Test
    public void testSelectRoleByUserIdChoose(){
        SqlSession sqlSession = getSqlSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        List<SysRole> roleList = roleMapper.selectRoleByUserIdChoose(1L);

        for (SysRole role : roleList) {
            System.out.println("角色名："+role.getRoleName());
            if (Objects.equals(1L,role.getId())){
                Assert.assertNotNull(role.getPrivilegeList());
            }
            if (Objects.equals(2L,role.getId())){
                Assert.assertNull(role.getPrivilegeList());
                continue;
            }
            for (SysPrivilege privilege : role.getPrivilegeList()) {
                System.out.println("权限名："+privilege.getPrivilegeName());
            }
        }

        sqlSession.close();
    }

    @Test
    public void testUpdateById(){
        SqlSession sqlSession = getSqlSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

        SysRoleType role = roleMapper.selectById(2L);
        Assert.assertEquals(Enabled.enabled,role.getEnabled());
        role.setEnabled(Enabled.disabled);
        roleMapper.updateById(role);

        sqlSession.close();
    }



}
