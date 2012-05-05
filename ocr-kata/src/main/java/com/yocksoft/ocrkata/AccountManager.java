package com.yocksoft.ocrkata;

import java.util.ArrayList;
import java.util.List;

import com.yocksoft.ocrkata.parser.AccountFile;
import com.yocksoft.ocrkata.parser.AccountFileException;
import com.yocksoft.ocrkata.parser.AccountParser;

public class AccountManager {

	private List<Account> accounts;
	private AccountParser accountParser = new AccountParser();

	public void setAccountParser(AccountParser accountParser) {
		this.accountParser = accountParser;
	}

	public AccountManager() {
		accounts = new ArrayList<>();
	}

	public void process(String location) {
		try {
			AccountFile accountFile = new AccountFile(location);
			while (accountFile.hasNext()) {
				char[] accountChars = accountFile.getNext();
				Account account = accountParser.parseAccount(accountChars);
				accounts.add(account);
				System.out.println(account);
			}
		} catch (AccountFileException e) {
			e.printStackTrace();
		}

	}
}
