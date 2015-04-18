package com.tuenti.challenge3.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


/**
 * The Class GamblersClubNumbers.
 * Calculates de number based on the two others
 */
public class GamblersClubNumbers {

	/**
	 * Gets the number.
	 * Return de square of the cuadratic sum
	 *
	 * @param num1 the num1
	 * @param num2 the num2
	 * @return the number
	 */
	private static Double getNumber(Integer num1, Integer num2) {
		return  Math.sqrt(((num1 * num1) + (num2 * num2)));
	}
	
	
	/**
	 * Gets the formated number with two decimals.
	 * @param num1 the num1
	 * @param num2 the num2
	 * @return the formated number
	 */
	public static String getFormatedNumber(Integer num1, Integer num2) {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(
				Locale.GERMAN);
		otherSymbols.setDecimalSeparator('.');
		otherSymbols.setGroupingSeparator('.');
		Double result = getNumber(num1,num2);
		DecimalFormat f = new DecimalFormat("##.##", otherSymbols);
		return f.format(result);
	}
}
