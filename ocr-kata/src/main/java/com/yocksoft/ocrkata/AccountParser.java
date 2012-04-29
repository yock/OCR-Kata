package com.yocksoft.ocrkata;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AccountParser {

	private static final int DIGIT_WIDTH = 3;
	private static final int[] BASE_COORDS = new int[] { 0, 1, 2, 28, 29, 30,
			56, 57, 58 };
	
	private Map<String, String> digitMap;
	
	public AccountParser() {
		init();
	}

	public Account parseAccount(char[] accountEntry) {
		StringBuilder sb= new StringBuilder();
		for (int i = 1; i <= 9; ++i) {
			sb.append(getDigitString(accountEntry, i));
		}
		return new Account(sb.toString());
	}

	private String getDigitString(char[] entry, int position) {
		StringBuilder digit = new StringBuilder();
		int widthOffset = (position - 1) * DIGIT_WIDTH;

		for (int i = 0; i < BASE_COORDS.length; ++i) {
			int entryCoord = BASE_COORDS[i] + widthOffset;
			digit.append(entry[entryCoord]);
		}

		String digitKey = digit.toString().trim();
		return digitMap.get(digitKey);
	}

	private void init() {
		Map<String, String> iMap = new HashMap<>();
		iMap.put("|  |", "1");
		iMap.put("_  _||_", "2");
		iMap.put("_  _| _|", "3");
		iMap.put("|_|  |", "4");
		iMap.put("_ |_  _|", "5");
		iMap.put("_ |_ |_|", "6");
		iMap.put("_   |  |", "7");
		iMap.put("_ |_||_|", "8");
		iMap.put("_ |_| _|", "9");
		digitMap = Collections.unmodifiableMap(iMap);
	}
	
}
