package org.trump.vincent.mybatis.enumeration.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.trump.vincent.mybatis.enumeration.GenderEnum;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenderEnumTypeHandler extends BaseTypeHandler<GenderEnum> {
    public void setNonNullParameter(PreparedStatement statement, int index, GenderEnum gender, JdbcType target) throws SQLException{
        statement.setInt(index,gender.getGenderCode());
    }

    public GenderEnum getNullableResult(ResultSet resultSet, String columnName) throws SQLException{
        return resultSet.wasNull()? null:
                GenderEnum.fromCode(
                        resultSet.getInt(columnName) );
    }

    public GenderEnum getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException{
        return resultSet.wasNull()? null:
                GenderEnum.fromCode(
                        resultSet.getInt(columnIndex) );
    }

    public GenderEnum getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException{
        return callableStatement.wasNull()? null:
                GenderEnum.fromCode(
                        callableStatement.getInt(columnIndex) );
    }

}
