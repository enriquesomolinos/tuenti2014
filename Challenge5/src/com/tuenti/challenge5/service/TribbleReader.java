package com.tuenti.challenge5.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.tuenti.challenge5.model.Tribble;

public class TribbleReader {

	public static Tribble readInput() {

		Tribble tribble = new Tribble();
		try {

			BufferedReader br;
			String line;

			br = new BufferedReader(new InputStreamReader(System.in));
			int column = 0;

			while ((line = br.readLine()) != null && column < Tribble.MAX_SIZE) {
				tribble.addRow(line, column);
				column++;
			}
			br.close();
			br = null;

		} catch (NumberFormatException e) {
			System.out.println("The input number is not correct");
		} catch (IOException e) {
			System.out.println("Error while reading input");
		}
		return tribble;
	}

}
