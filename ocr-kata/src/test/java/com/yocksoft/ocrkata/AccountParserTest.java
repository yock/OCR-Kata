package com.yocksoft.ocrkata;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class AccountParserTest {

	private AccountParser accountParser;
	private char[] rawAccountData;

	@Before
	public void setup() {
		accountParser = new AccountParser();
		String strAccount = "    _  _     _  _  _  _  _ \n"
				+ "  | _| _||_||_ |_   ||_||_|\n"
				+ "  ||_  _|  | _||_|  ||_| _|\n"
				+ "                           \n";
		rawAccountData = strAccount.toCharArray();
	}

	@Test
	public void testParseAccount() {
		Account account = accountParser.parseAccount(rawAccountData);
		assertThat(account.getAccountNumber(), is("123456789"));
	}

}
