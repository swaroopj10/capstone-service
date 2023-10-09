package com.tradewave.business;



public enum RiskTolerance {
	CONSERVATIVE("CONSERVATIVE"),
    BELOW_AVERAGE("BELOW_AVERAGE"),
    AVERAGE("AVERAGE"),
    ABOVE_AVERAGE("ABOVE_AVERAGE"),
    AGGRESSIVE("AGGRESIVE");
	private String value;
	private RiskTolerance(String value) {
		this.value=value;
	}
	public String getCode() {
		return this.value;
	}
	public static RiskTolerance of(String code) {
		for (RiskTolerance ct: values()) {
			if (ct.value.equals(code)) {
				return ct;
			}
		}
		throw new IllegalArgumentException("Unknown code");
	}
}
