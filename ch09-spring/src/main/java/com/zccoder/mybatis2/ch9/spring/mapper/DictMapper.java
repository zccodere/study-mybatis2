package com.zccoder.mybatis2.ch9.spring.mapper;

import com.zccoder.mybatis2.ch9.spring.model.SysDict;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 标题：字典表 Mapper<br>
 * 描述：字典表 Mapper<br>
 * 时间：2018/06/27<br>
 *
 * @author zc
 **/
public interface DictMapper {

    /**
     * 根据主键查询
     *
     * @param id ID
     * @return 字典
     */
    SysDict selectByPrimaryKey(Long id);

    /**
     * 条件查询
     *
     * @param sysDict 字典
     * @param rowBounds 分页
     * @return 字典列表
     */
    List<SysDict> selectBySysDict(SysDict sysDict, RowBounds rowBounds);

    /**
     * 新增
     *
     * @param sysDict 字典
     * @return 影响条数
     */
    int insert(SysDict sysDict);

    /**
     * 根据主键更新
     *
     * @param sysDict 字典
     * @return 影响条数
     */
    int updateById(SysDict sysDict);

    /**
     * 根据主键删除
     *
     * @param id ID
     * @return 影响条数
     */
    int deleteById(Long id);
}
