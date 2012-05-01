package com.yocksoft.ocrkata;

public class AccountMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AccountManager accountManager = new AccountManager();
		accountManager.process(args[0]);
	}

}
