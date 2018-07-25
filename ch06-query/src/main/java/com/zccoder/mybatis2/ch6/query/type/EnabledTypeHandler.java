package com.zccoder.mybatis2.ch6.query.type;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 标题：EnabledType 类型处理器<br>
 * 描述：EnabledType 类型处理器<br>
 * 时间：2018/06/22<br>
 *
 * @author zc
 **/
public class EnabledTypeHandler implements TypeHandler<EnabledType>{

    private final Map<Integer,EnabledType> enabledMap = new HashMap<Integer,EnabledType>(EnabledType.values().length);

    public EnabledTypeHandler(){
        for (EnabledType enabledType : EnabledType.values()) {
            enabledMap.put(enabledType.getValue(),enabledType);
        }
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, EnabledType parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getValue());
    }

    @Override
    public EnabledType getResult(ResultSet rs, String columnName) throws SQLException {
        Integer value = rs.getInt(columnName);
        return enabledMap.get(value);
    }

    @Override
    public EnabledType getResult(ResultSet rs, int columnIndex) throws SQLException {
        Integer value = rs.getInt(columnIndex);
        return enabledMap.get(value);
    }

    @Override
    public EnabledType getResult(CallableStatement cs, int columnIndex) throws SQLException {
        Integer value = cs.getInt(columnIndex);
        return enabledMap.get(value);
    }
}
