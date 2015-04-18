package com.tuenti.challenge11;

import java.io.IOException;

import com.tuenti.challenge11.security.AESResolver;

public class Challenge11 {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {

		AESResolver resolver = new AESResolver();
		resolver.resolveKey("17023", "hNMqffpeMSqUqNfbvSDImDRQmtSbU");

	}

}
