package com.tradewave.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tradewave.business.InvestmentPreference;
import com.tradewave.integration.mapper.PreferenceMapper;


@Repository("PrefernceDao")
public class PreferenceDaoImpl implements PreferenceDao{
	@Autowired
	private PreferenceMapper mapper;
	@Override
	public InvestmentPreference getPreferencebyId(String id) {
		InvestmentPreference invPref=mapper.getPreferencebyId(id);
		return invPref;
	}

	@Override
	public int insertPreference(InvestmentPreference investmentpreference) {
		int count=mapper.insertPreference(investmentpreference);
		return count;
	}

	@Override
	public int updatePreference(InvestmentPreference investmentpreference) {
		int count=mapper.updatePreference(investmentpreference);
		return count;
	}

}
