package com.tuenti.challenge1.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import com.tuenti.challenge1.model.Person;
import com.tuenti.challenge1.util.collection.PeopleCollection;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentReader.
 */
public class StudentReader {

	/** The Constant SEPARATOR. */
	private static final String SEPARATOR = ",";

	/**
	 * Read the student file.
	 *
	 * @param file the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void readFile(String file) throws IOException {
		
		BufferedReader br;
		String line;
		
		br = new BufferedReader(new InputStreamReader(getClass()
				.getResourceAsStream(file), Charset.forName("UTF-8")));

		while ((line = br.readLine()) != null) {

			String[] values = line.split(SEPARATOR);
			Person person = new Person(values);
			PeopleCollection.getInstance().addPerson(person);
		}

		// Done with the file
		br.close();
		br = null;
	}

}
