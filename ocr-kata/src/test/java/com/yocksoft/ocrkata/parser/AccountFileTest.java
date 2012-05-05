package com.yocksoft.ocrkata.parser;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.yocksoft.ocrkata.parser.AccountFile;

public class AccountFileTest {
	
	private AccountFile accountFile;

	@Before
	public void setup() throws Exception {
		accountFile = new AccountFile("src/test/resources/in.txt");
	}

	@Test
	public void testGetNext() throws Exception {
		char[] account = accountFile.getNext();
		assertThat(account.length, is(84));
	}
	
	@Test
	public void testHasNext() {
		boolean hasNext = accountFile.hasNext();
		assertThat(hasNext, is(true));
	}

}
