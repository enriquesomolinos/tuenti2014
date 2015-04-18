package com.tuenti.challenge1;

import java.io.IOException;
import com.tuenti.challenge1.service.InputReader;
import com.tuenti.challenge1.service.StudentReader;
import com.tuenti.util.ConsoleLog;

/**
 * The Class Challenge1.
 */
public class Challenge1 {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		StudentReader studentReader = new StudentReader();
		InputReader inputReader = new InputReader();

		try {

			studentReader.readFile("/data/students");

		} catch (IOException e) {
			System.out.println("Error while reading the file");
		}

		try {
			inputReader.readInput();

			ConsoleLog.getInstance().printMessages();
		} catch (IOException e) {
			System.out.println("Error while reading the input data");
		}
	}

}
