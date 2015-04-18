package com.tuenti.challenge2;

import java.io.IOException;

import com.tuenti.challenge2.model.Circuit;
import com.tuenti.challenge2.operation.Operation;
import com.tuenti.challenge2.operation.OperationFactory;
import com.tuenti.challenge2.service.FIACircuitReader;

/**
 * The Class Challenge2.
 */
public class Challenge2 {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		Circuit FIACircuit = new Circuit();
		FIACircuitReader fiaCircuitReader = new FIACircuitReader();
		try {
			String stringCircuit = fiaCircuitReader.readInput().toString();
			for (int i = 0; i < stringCircuit.length(); i++) {
				Operation operation = OperationFactory.getOperation(
						String.valueOf(stringCircuit.charAt(i)), FIACircuit);

				operation.execute();

			}

			FIACircuit.printMeInConsole();

		} catch (IOException e) {
			System.out.println("Error while reading the input");
		}

	}

}
