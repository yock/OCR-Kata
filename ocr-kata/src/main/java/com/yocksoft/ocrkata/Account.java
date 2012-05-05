package com.yocksoft.ocrkata;

public class Account {
	
	private String accountNumber;
	private boolean valid;
	
	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Account: ");
		stringBuilder.append(this.accountNumber);
		return stringBuilder.toString();
	}

}
