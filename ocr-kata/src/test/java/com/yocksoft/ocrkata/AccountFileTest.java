package com.yocksoft.ocrkata;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class AccountFileTest {

	private AccountFile accountFile;

	@Before
	public void setup() {
		accountFile = new AccountFile();
		accountFile.setLocation("src/test/resources/in.txt");
	}

	@Test
	public void test() throws Exception {
		char[] account = accountFile.getNext();
		assertThat(account.length, is(112));
	}

}
