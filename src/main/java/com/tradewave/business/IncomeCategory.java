package com.tradewave.business;


public enum IncomeCategory {
	BELOW_TWENTY_THOUSAND("0-20,000"),
    TWENTY_TO_FORTY("20,001-40,000"),
    FORTY_TO_SIXTY("40,001-60,000"),
    SIXTY_TO_EIGHTY("60,001-80,000"),
    EIGHTY_TO_ONE_LAKH("80,001-100,000"),
    ONE_LAKH_TO_ONE_lAKH_FIFTY("100,001-150,000"),
    ABOVE_ONE_LAKH_FIFTY("150,000+");
	private String incomeCategory;
	private IncomeCategory(String incomeCategory) {
	        this.incomeCategory = incomeCategory;
	}
	public static IncomeCategory of(String code) {
		for (IncomeCategory ct: values()) {
			if (ct.incomeCategory.equals(code)) {
				return ct;
			}
		}
		throw new IllegalArgumentException("Unknown code");
	}
	public String getCode() {
		return incomeCategory;
	}
}
