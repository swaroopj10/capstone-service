package com.tradewave.enumTypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.tradewave.business.RiskTolerance;



public class RiskToleranceTypeHandler extends BaseTypeHandler<RiskTolerance> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, RiskTolerance parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i,parameter.getCode());
	}

	@Override
	public RiskTolerance getNullableResult(ResultSet rs, String columnName) throws SQLException {
		if(rs.getString(columnName)!="") {
			return RiskTolerance.of(rs.getString(columnName));
		}
		else {
			return null;
		}
	}

	@Override
	public RiskTolerance getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return null;
	}

	@Override
	public RiskTolerance getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return null;
	}

}
