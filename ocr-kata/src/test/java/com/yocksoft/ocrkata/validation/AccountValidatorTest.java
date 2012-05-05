package com.yocksoft.ocrkata.validation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.yocksoft.ocrkata.Account;

public class AccountValidatorTest {
	
	private AccountValidator accountValidator;
	
	@Before
	public void setup() {
		accountValidator = new AccountValidator();
	}

	@Test
	public void testIsValid() {
		boolean valid = accountValidator.isValid(new Account("457508000"));
		assertTrue(valid);
		valid = accountValidator.isValid(new Account("664371495"));
		assertTrue(!valid);
	}
	
	@Test
	public void testIsValidWithBlankAccount() {
		boolean valid = accountValidator.isValid(new Account(""));
		assertTrue(!valid);
	}
	
	public void testIsValidWithNullAccountNumber() {
		boolean valid = accountValidator.isValid(new Account(null));
		assertTrue(!valid);
	}
	
	public void testIsValidWithNullAccount() {
		boolean valid = accountValidator.isValid(null);
		assertTrue(!valid);
	}
	
}
