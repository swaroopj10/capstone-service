package com.tradewave.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradewave.business.InvestmentPreference;
import com.tradewave.integration.PreferenceDao;


@Service
public class PreferenceServiceImpl implements PreferenceService {
	@Autowired
	PreferenceDao dao;

	@Override
	public InvestmentPreference getPreferencebyId(String id) {
		InvestmentPreference invPref;
		try {
			invPref=dao.getPreferencebyId(id);
		}
		catch(Exception e) {
			String msg = "Error querying all presidents in the presidents database.";
			throw new PreferenceDatabaseException(msg,e);
		}
		return invPref;
	}

	@Override
	public int insertPreference(InvestmentPreference investmentpreference) {
		int count=0;
		try {
			count=dao.insertPreference(investmentpreference);
		}
		catch(Exception e) {
			String msg = "Error inserting presidents in the presidents database.";
			throw new PreferenceDatabaseException(msg,e);
		}
		return count;
	}

	@Override
	public int updatePreference(InvestmentPreference investmentpreference) {
		int count=0;
		try {
			count=dao.updatePreference(investmentpreference);
		}
		catch(Exception e) {
			String msg = "Error updating presidents in the presidents database.";
			throw new PreferenceDatabaseException(msg,e);
		}
		return count;
	}
	

}
