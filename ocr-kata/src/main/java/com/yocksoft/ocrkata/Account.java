package com.yocksoft.ocrkata;

public class Account {
	
	private String accountNumber;
	
	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Account: ");
		stringBuilder.append(this.accountNumber);
		return stringBuilder.toString();
	}

}
