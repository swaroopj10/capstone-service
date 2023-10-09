package com.tradewave.business;

import java.util.Objects;

public class InvestmentPreference {

	private int clientId;
	private String investmentPurpose = "";
    private InvestmentLength investmentLength = null;
    private RiskTolerance riskTolerance = null;
    private IncomeCategory incomeCategory = null;
    
    public InvestmentPreference() {}
    
    public InvestmentPreference(int clientId,String investmentPurpose, InvestmentLength investmentLength, RiskTolerance riskTolerance, IncomeCategory incomeCategory) {
		this.investmentPurpose = investmentPurpose;
		this.investmentLength = investmentLength;
		this.riskTolerance = riskTolerance;
		this.incomeCategory = incomeCategory;
		this.clientId=clientId;
	}
    
    public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getInvestmentPurpose() {
		return investmentPurpose;
	}

	public void setInvestmentPurpose(String investmentPurpose) {
		this.investmentPurpose = investmentPurpose;
	}

	public InvestmentLength getInvestmentLength() {
		return investmentLength;
	}

	public void setInvestmentLength(InvestmentLength investmentLength) {
		this.investmentLength = investmentLength;
	}

	public RiskTolerance getRiskTolerance() {
		return riskTolerance;
	}

	public void setRiskTolerance(RiskTolerance riskTolerance) {
		this.riskTolerance = riskTolerance;
	}

	public IncomeCategory getIncomeCategory() {
		return incomeCategory;
	}

	public void setIncomeCategory(IncomeCategory incomeCategory) {
		this.incomeCategory = incomeCategory;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientId, incomeCategory, investmentLength, investmentPurpose, riskTolerance);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvestmentPreference other = (InvestmentPreference) obj;
		return clientId == other.clientId && incomeCategory == other.incomeCategory
				&& investmentLength == other.investmentLength
				&& Objects.equals(investmentPurpose, other.investmentPurpose) && riskTolerance == other.riskTolerance;
	}

	@Override
	public String toString() {
		return "InvestmentPreference [clientId=" + clientId + ", investmentPurpose=" + investmentPurpose
				+ ", investmentLength=" + investmentLength + ", riskTolerance=" + riskTolerance + ", incomeCategory="
				+ incomeCategory + "]";
	}
	
	
}
