package com.tuenti.challenge8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import com.tuenti.challenge8.model.Layout;
import com.tuenti.challenge8.solver.Resolver;


/**
 * The Class Challenge8.
 * Se resuelven los puzzles 3x3 mediante el algoritmo A* utilzando como heuristica
 * el numero de movimientos mas la distancia de manhatan de los trabajadores en el puzzle
 * multiplicandolas por la constante 0.6 que significa que la distancia de manhatan practivamente
 * la dividimos entre dos, ya que cada movimiento entre dos personas debe contar con 1 y no como 2.
 * 
 * Tambien se ha optimizado el algoritmo , ya que al final en todos los puzzles hay que llegar a
 * una solucion del tipo:
 * 
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * 
 * Independientemente de los nombres cualquier camino utilizado para una solucion es un camino optimo
 * y lo podemos utilizar en cualquier otro puzzle, ya que todos los puzzles los transformamos al 
 * modo numerico.
 * 
 */
public class Challenge8 {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {

		String line;
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in, Charset.forName("UTF-8")));

		Integer numTables = Integer.parseInt(reader.readLine().trim());

		Integer[][] solutionIntegerLayout = { { 1, 2, 3 }, { 4, 5, 6 },
				{ 7, 8, 9 } };
		for (int i = 0; i < numTables; i++) {

			reader.readLine();
			String[] table1line1 = reader.readLine().trim().split(",");
			String[] table1line2 = reader.readLine().trim().split(",");
			String[] table1line3 = reader.readLine().trim().split(",");
			reader.readLine();

			// tabla dos
			String[] table2line1 = reader.readLine().trim().split(",");
			String[] table2line2 = reader.readLine().trim().split(",");
			String[] table2line3 = reader.readLine().trim().split(",");

			solve(table1line1, table1line2, table1line3, table2line1,
					table2line2, table2line3, solutionIntegerLayout);

		}

	}

	/**
	 * llama al resolutor del problema para cada puzzle
	 *
	 * @param table1line1 the table1line1
	 * @param table1line2 the table1line2
	 * @param table1line3 the table1line3
	 * @param table2line1 the table2line1
	 * @param table2line2 the table2line2
	 * @param table2line3 the table2line3
	 * @param solutionIntegerLayout the solution integer layout
	 */
	public static void solve(String[] table1line1, String[] table1line2,
			String[] table1line3, String[] table2line1, String[] table2line2,
			String[] table2line3, Integer[][] solutionIntegerLayout) {
		String[][] table1 = new String[Layout.DIMENSION][Layout.DIMENSION];
		table1[0] = table1line1;
		table1[1] = table1line2;
		table1[2] = table1line3;

		String[][] tableSolution = new String[Layout.DIMENSION][Layout.DIMENSION];
		tableSolution[0] = table2line1;
		tableSolution[1] = table2line2;
		tableSolution[2] = table2line3;

		Layout solution = new Layout(tableSolution, solutionIntegerLayout);

		Layout initialLayout = new Layout(table1, solution);

		// System.out.println(initialLayout.toString());
		// System.out.println(solution.toString());
		Resolver resolver = new Resolver();

		Integer moves = resolver.resolve(initialLayout);
		if (moves == null) {
			System.out.println("-1");
		} else {
			System.out.println(moves);
		}

	}

}
