package com.tradewave.restcontroller;

public class TradeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TradeException() {
		super();
	}

	public TradeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TradeException(String message, Throwable cause) {
		super(message, cause);
	}

	public TradeException(String message) {
		super(message);
	}

	public TradeException(Throwable cause) {
		super(cause);
	}
}
