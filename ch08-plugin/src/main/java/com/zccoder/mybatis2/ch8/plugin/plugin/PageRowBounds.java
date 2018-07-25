package com.zccoder.mybatis2.ch8.plugin.plugin;

import org.apache.ibatis.session.RowBounds;

/**
 * 标题：记录 total<br>
 * 描述：记录 total<br>
 * 时间：2018/06/26<br>
 *
 * @author zc
 **/
public class PageRowBounds extends RowBounds {
    /***
     * 总记录数
     */
    private long total;

    public PageRowBounds() {
        super();
    }

    public PageRowBounds(int offset, int limit) {
        super(offset, limit);
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
