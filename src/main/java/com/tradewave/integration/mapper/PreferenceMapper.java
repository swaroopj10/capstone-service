package com.tradewave.integration.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tradewave.business.InvestmentPreference;

@Mapper
public interface PreferenceMapper {
	@Select("SELECT CLIENTID,INVESTMENTPURPOSE,INVESTMENTLENGTH,RISKTOLERANCE,INCOMECATEGORY FROM CP_INVESTMENT_PREFERENCE WHERE CLIENTID=#{id}")
	@Result(property="clientId",column="CLIENTID",id=true)
	@Result(property="investmentPurpose",column="INVESTMENTPURPOSE")
	@Result(property="incomeCategory",column="INCOMECATEGORY",typeHandler=com.tradewave.enumTypeHandler.IncomeCategoryTypeHandler.class)
	@Result(property="investmentLength",column="INVESTMENTLENGTH",typeHandler=com.tradewave.enumTypeHandler.InvestmentLengthTypeHandler.class)
	@Result(property="riskTolerance",column="RISKTOLERANCE",typeHandler=com.tradewave.enumTypeHandler.RiskToleranceTypeHandler.class)
	InvestmentPreference getPreferencebyId(String id);
	
	@Insert("INSERT INTO cp_investment_preference(CLIENTID,INVESTMENTPURPOSE,INVESTMENTLENGTH,RISKTOLERANCE,INCOMECATEGORY)"
			+ "	VALUES (#{clientId},#{investmentPurpose},"
			+ "			#{investmentLength, typeHandler=com.tradewave.enumTypeHandler.InvestmentLengthTypeHandler},"
			+ "			#{riskTolerance, typeHandler=com.tradewave.enumTypeHandler.RiskToleranceTypeHandler},"
			+ "			#{incomeCategory, typeHandler=com.tradewave.enumTypeHandler.IncomeCategoryTypeHandler})")
	int insertPreference(InvestmentPreference investmentpreference);
	
	@Update("""
			UPDATE cp_investment_preference
			SET  INVESTMENTPURPOSE=#{investmentPurpose},
			RISKTOLERANCE=#{riskTolerance, typeHandler=com.tradewave.enumTypeHandler.RiskToleranceTypeHandler},
			INVESTMENTLENGTH=#{investmentLength, typeHandler=com.tradewave.enumTypeHandler.InvestmentLengthTypeHandler},
			INCOMECATEGORY=#{incomeCategory, typeHandler=com.tradewave.enumTypeHandler.IncomeCategoryTypeHandler} WHERE CLIENTID=#{clientId}
			""")
	int updatePreference(InvestmentPreference investmentpreference);
}
