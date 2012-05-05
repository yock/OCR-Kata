package com.yocksoft.ocrkata.parser;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.yocksoft.ocrkata.AccountManager;
import com.yocksoft.ocrkata.parser.AccountParser;

public class AccountManagerTest {

	@Mock
	private AccountParser accountParser;

	@InjectMocks
	private AccountManager accountManager;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testProcess() {
		accountManager.process("src/test/resources/in.txt");
		Mockito.verify(accountParser).parseAccount(Mockito.any(char[].class));
	}

}
