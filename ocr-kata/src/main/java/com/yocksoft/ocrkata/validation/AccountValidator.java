package com.yocksoft.ocrkata.validation;

import com.yocksoft.ocrkata.Account;

public class AccountValidator {

	public boolean isValid(Account account) {
		if (account == null)
			return false;
		String accountNumber = account.getAccountNumber();
		if (accountNumber == null)
			return false;
		if (accountNumber.equals(""))
			return false;
		return isValid(accountNumber);
	}

	private boolean isValid(String accountNumber) {
		int[] ints = toIntArray(accountNumber);
		int result = (ints[8] + 2 * ints[7] + 3 * ints[6] + 4 * ints[5] + 5
				* ints[4] + 6 * ints[3] + 7 * ints[2] + 8 * ints[1] + 9 * ints[0]) % 11;
		return (result == 0);
	}

	private int[] toIntArray(String accountNumber) {
		int[] accountInts = new int[9];
		char[] charArray = accountNumber.toCharArray();
		for (int i = 0; i < accountInts.length; ++i) {
			accountInts[i] = Integer.parseInt(String.valueOf(charArray[i]));
		}
		return accountInts;
	}
}
