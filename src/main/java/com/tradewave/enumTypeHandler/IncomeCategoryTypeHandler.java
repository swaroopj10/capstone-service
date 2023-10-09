package com.tradewave.enumTypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.tradewave.business.IncomeCategory;



public class IncomeCategoryTypeHandler extends BaseTypeHandler<IncomeCategory>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, IncomeCategory parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i,parameter.getCode());
	}

	
	@Override
	public IncomeCategory getNullableResult(ResultSet rs, String columnName) throws SQLException {
		if(rs.getString(columnName)!="") {
			return IncomeCategory.of(rs.getString(columnName));
		}
		else {
			return null;
		}
	}

	@Override
	public IncomeCategory getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return null;
	}

	@Override
	public IncomeCategory getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return null;
	}

}
