package com.tradewave.business;


public enum InvestmentLength {
	ZERO_TO_FIVE("0-5YEARS"), 
	FIVE_TO_SEVEN("5-7YEARS"), 
	SEVEN_TO_TEN("7-10YEARS"), 
	TEN_TO_FIFTEEN("10-15YEARS");

	private String value;
	private InvestmentLength(String value) {
		this.value = value;
	}
	
	public String getCode() {
		return value;
	}
	public static InvestmentLength of(String code) {
		for (InvestmentLength ct: values()) {
			if (ct.value.equals(code)) {
				return ct;
			}
		}
		//throw new IllegalArgumentException("Unknown code");
		return null;
}
}
