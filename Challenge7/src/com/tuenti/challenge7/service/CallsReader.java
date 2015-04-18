package com.tuenti.challenge7.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import com.tuenti.challenge7.model.Call;
import com.tuenti.challenge7.util.CallsColletion;

/**
 * The Class CallsReader.
 */
public class CallsReader {

	/** The Constant SEPARATOR. */
	private static final String SEPARATOR = " ";

	/**
	 * Read file.
	 *
	 * @param file the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void readFile(String file) throws IOException {

		BufferedReader br;
		String line;
		
	
		br = new BufferedReader(new InputStreamReader(getClass()
				.getResourceAsStream(file), Charset.forName("UTF-8")));

		Long iteration = 0L;
		while ((line = br.readLine()) != null) {

			String[] values = line.split(SEPARATOR);
			Call call = new Call(Long.valueOf(values[0]),
					Long.valueOf(values[1]), iteration);
			CallsColletion.getInstance().addCall(call);
			iteration++;
		}

		// Done with the file
		br.close();
		br = null;
	}

}
