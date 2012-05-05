package com.yocksoft.ocrkata.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayDeque;
import java.util.Deque;

public class AccountFile {
	private String location;
	private Deque<CharBuffer> accountChunks;

	public AccountFile(String location) throws AccountFileException {
		this.location = location;
		this.accountChunks = new ArrayDeque<>();
		init();
	}

	public char[] getNext() {
		return accountChunks.removeFirst().array();
	}

	public boolean hasNext() {
		return accountChunks.size() > 0;
	}
	
	private void init() throws AccountFileException {
		try (BufferedReader reader = new BufferedReader(new FileReader(location))) {
			while (reader.ready()) {
				CharBuffer buf = CharBuffer.allocate(28 * 3);
				reader.read(buf);
				accountChunks.addLast(buf);
				reader.skip(28L);
			}
		} catch (IOException e) {
			throw new AccountFileException();
		}
	}
}