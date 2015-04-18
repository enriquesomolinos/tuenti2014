package com.tuenti.challenge2.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Class FIACircuitReader.
 */
public class FIACircuitReader {

	/**
	 * Read input.
	 * 
	 * @return the string buffer
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public StringBuffer readInput() throws IOException {

		BufferedReader br;
		String line;
		StringBuffer stringBufferCircuit = new StringBuffer();

		br = new BufferedReader(new InputStreamReader(System.in));

		while ((line = br.readLine()) != null) {
			stringBufferCircuit.append(line);
		}
		// Done with the file
		br.close();
		br = null;

		return stringBufferCircuit;

	}

}
