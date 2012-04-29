package com.yocksoft.ocrkata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

public class AccountFile {
	public String location;
	public Reader reader;

	public void setLocation(String location) {
		this.location = location;
	}

	private Reader readFile() throws IOException {
		return reader == null ? new BufferedReader(new FileReader(location))
				: reader;
	}

	public char[] getNext() {
		try (Reader reader = readFile()) {
			while (reader.ready()) {
				CharBuffer cbuf = CharBuffer.allocate(28 * 4);
				reader.read(cbuf);
				return cbuf.array();
			}
		} catch (IOException e) {
			System.err.println("Error reading file.");
		}
		return null;
	}
}