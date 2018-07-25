package com.zccoder.mybatis2.ch9.spring.service;


import com.zccoder.mybatis2.ch9.spring.model.SysDict;

import java.util.List;

/**
 * 标题：字典服务<br>
 * 描述：字典服务<br>
 * 时间：2018/06/27<br>
 *
 * @author zc
 **/
public interface DictService {
    /**
     * 通过ID查询字典
     *
     * @param id ID
     * @return 字典
     */
    SysDict findById(Long id);

    /**
     * 分页查询
     *
     * @param sysDict 字典
     * @param offset  开始位置
     * @param limit   长度
     * @return 字典列表
     */
    List<SysDict> findBySysDict(SysDict sysDict, Integer offset, Integer limit);

    /**
     * 保存或更新
     *
     * @param sysDict
     * @return 结果
     */
    boolean saveOrUpdate(SysDict sysDict);

    /**
     * 删除
     *
     * @param id ID
     * @return 结果
     */
    boolean deleteById(Long id);
}
