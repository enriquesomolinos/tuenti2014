package com.tuenti.challenge1.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.tuenti.challenge1.model.AnonymousPerson;
import com.tuenti.challenge1.model.Person;
import com.tuenti.challenge1.util.collection.PeopleCollection;
import com.tuenti.util.ConsoleLog;

// TODO: Auto-generated Javadoc
/**
 * The Class InputReader.
 */
public class InputReader {

	/** The Constant MAX_LINES. */
	private static final int MAX_LINES = 100;
	
	/** The Constant SEPARATOR. */
	private static final String SEPARATOR = ",";
	
	/** The Constant NONE_MESSAGE. */
	private static final String NONE_MESSAGE = "NONE";

	/**
	 * Read input data of the challenge
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void readInput() throws IOException {
		String line;
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		Integer numLines = Integer.parseInt(reader.readLine().trim());

		for (int i = 0; i < numLines && i < MAX_LINES; i++) {
			line = reader.readLine();
			if (line != null && !line.trim().equals("")) {

				String[] values = line.split(SEPARATOR);
				AnonymousPerson anonimousPerson = new AnonymousPerson(values);
				List<Person> personList =PeopleCollection.getInstance().getPeople(anonimousPerson.hashCode());
				StringBuffer sb = new StringBuffer();
				if(personList!=null){					
					for	(Person person : personList) {
						if(sb.length()>0){
							sb.append(","+person.toString());			
						}else{
							sb.append(person.toString());
						}
					}
					ConsoleLog.getInstance().addMessage(sb.toString());					
				}	
				else{
					ConsoleLog.getInstance().addMessage(NONE_MESSAGE);
				}
			}
		}
	}

}
