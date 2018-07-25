package com.zccoder.mybatis2.ch8.plugin;

import com.zccoder.mybatis2.ch8.plugin.mapper.RoleMapper;
import com.zccoder.mybatis2.ch8.plugin.model.SysRole;
import com.zccoder.mybatis2.ch8.plugin.plugin.PageRowBounds;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 标题：角色Mapper测试类<br>
 * 描述：角色Mapper测试类<br>
 * 时间：2018/06/26<br>
 *
 * @author zc
 **/
public class RoleMapperTest extends BaseMapperTest{

    @Test
    public void testSelectById(){
        SqlSession sqlSession = getSqlSession();
        RoleMapper roleMapper = (RoleMapper)sqlSession.getMapper(RoleMapper.class);
        // 使用 RowBounds 类型时不会查询总数
        RowBounds rowBounds = new RowBounds(0,1);
        List<SysRole> roleList = roleMapper.selectAll(rowBounds);
        for (SysRole role : roleList) {
            System.out.println("角色名："+role.getRoleName());
        }

        // 使用 PageRowBounds 类型时会查询总数
        PageRowBounds pageRowBounds = new PageRowBounds(0,1);
        roleList = roleMapper.selectAll(pageRowBounds);
        // 获取总数
        System.out.println("查询总数：" + pageRowBounds.getTotal());
        for (SysRole role : roleList) {
            System.out.println("角色名："+role.getRoleName());
        }

        // 再次查询
        pageRowBounds = new PageRowBounds(1,1);
        roleList = roleMapper.selectAll(pageRowBounds);
        // 获取总数
        System.out.println("查询总数：" + pageRowBounds.getTotal());
        for (SysRole role : roleList) {
            System.out.println("角色名："+role.getRoleName());
        }

        sqlSession.close();
    }
}
