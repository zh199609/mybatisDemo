package com.zl.config;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EnableTypeHandler implements TypeHandler<Enabled> {

    Map<Integer, Enabled> map = new HashMap();

    public EnableTypeHandler() {
        for (Enabled enabled : Enabled.values()) {
            map.put(enabled.getValue(), enabled);
        }
    }

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Enabled enabled, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, enabled.getValue());
    }

    @Override
    public Enabled getResult(ResultSet resultSet, String s) throws SQLException {
        int resultSetInt = resultSet.getInt(s);
        return map.get(resultSetInt);
    }

    @Override
    public Enabled getResult(ResultSet resultSet, int i) throws SQLException {
        int resultSetInt = resultSet.getInt(i);
        return map.get(resultSetInt);
    }

    @Override
    public Enabled getResult(CallableStatement callableStatement, int i) throws SQLException {
        int resultSetInt = callableStatement.getInt(i);
        return map.get(resultSetInt);
    }
}
