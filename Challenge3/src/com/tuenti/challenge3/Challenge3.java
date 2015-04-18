package com.tuenti.challenge3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.tuenti.challenge3.util.GamblersClubNumbers;

/**
 * The Class Challenge3.
 */
public class Challenge3 {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		
		String line;
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		Integer numLines;
		try {
			numLines = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < numLines; i++) {
				line = reader.readLine();
				String[] values = line.split(" ");

				Integer num1 = Integer.parseInt(values[0].trim());
				Integer num2 = Integer.parseInt(values[1].trim());

				String result = GamblersClubNumbers.getFormatedNumber(num1,
						num2);

				System.out.println(result);

			}
		} catch (NumberFormatException e) {
			System.out.println("The input number is not correct");
		} catch (IOException e) {
			System.out.println("Erro while reading input");
		}

	}

}
