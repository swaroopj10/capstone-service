package com.tradewave.restcontroller;

public class DatabaseRequestResult {
	private int rowCount;
	private String message;
	
	public DatabaseRequestResult () {}
	
	public DatabaseRequestResult(int rowCount) {
		this.rowCount = rowCount;
	}
	
	public DatabaseRequestResult(int rowCount, String message) {
		this.rowCount = rowCount;
		this.message = message;
	}

	public int getRowCount() {
		return rowCount;
	}
	
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
