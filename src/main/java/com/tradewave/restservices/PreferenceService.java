package com.tradewave.restservices;

import com.tradewave.business.InvestmentPreference;

public interface PreferenceService {
	InvestmentPreference getPreferencebyId(String id);
	int insertPreference(InvestmentPreference investmentpreference);
	int updatePreference(InvestmentPreference investmentpreference);
}
