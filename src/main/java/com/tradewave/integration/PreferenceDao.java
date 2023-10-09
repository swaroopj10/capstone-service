package com.tradewave.integration;

import com.tradewave.business.InvestmentPreference;

public interface PreferenceDao {
	InvestmentPreference getPreferencebyId(String id);
	int insertPreference(InvestmentPreference investmentpreference);
	int updatePreference(InvestmentPreference investmentpreference);
}
