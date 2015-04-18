package com.tuenti.challenge7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.tuenti.challenge7.model.Call;
import com.tuenti.challenge7.service.CallsReader;
import com.tuenti.challenge7.util.CallsColletion;


/**
 * The Class Challenge7.
 */
public class Challenge7 {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {

		CallsReader callsReader = new CallsReader();

		callsReader.readFile("/data/phone_call.log");

		Long origin;
		Long dest;
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		origin = Long.valueOf(reader.readLine().trim());
		dest = Long.valueOf(reader.readLine().trim());

		/*realizamos un recorrido en anchura a partir del telefono inicial
		 * Cada vez que navegamos un nuevo nivel eliminamos de las posibles navegaciones
		 * las llamadas obtenidas para no obtenerlas mas adelante.
		 * 
		 */
		List<Call> listCalls = CallsColletion.getInstance().getCallsAndErase(
				origin);
		if (listCalls != null && containsDestiny(listCalls, dest) != null) {
			System.out.println("Connected at "
					+ containsDestiny(listCalls, dest).getCallId());
			System.exit(1);
		} else {
			if (listCalls == null) {
				System.out.println("Not connected");
				System.exit(1);
			}
		}

		do {
			listCalls = CallsColletion.getInstance()
					.getCallsAndErase(listCalls);
			if (containsDestiny(listCalls, dest) != null) {
				System.out.println("Connected at "
						+ containsDestiny(listCalls, dest).getCallId());
				System.exit(1);
			}

		} while (listCalls.size() > 0 && CallsColletion.getInstance().hasData());

		System.out.println("Not connected");

	}

	/**
	 * Contains destiny.
	 *
	 * @param listCalls the list calls
	 * @param destiny the destiny
	 * @return the call
	 */
	public static Call containsDestiny(List<Call> listCalls, Long destiny) {
		for (Call call : listCalls) {
			if (call.contains(destiny)) {
				return call;
			}
		}
		return null;
	}
}
