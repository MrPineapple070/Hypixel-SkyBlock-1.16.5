package net.hypixel.skyblock.util;

import java.util.Collections;

import javax.annotation.concurrent.Immutable;

/**
 * Converts to and from int and Roman numerals
 * @author MrPineapple070
 * @version 11 July 2019
 * @since 11 July 2019
 */
@Immutable
public class RomanNumeralConverter {
	/**
	 * Converts to Roman Numeral
	 * @param number int to convert
	 * @return converted
	 */
	public static final String toRomanNumber(int number) {
		return String.join("", Collections.nCopies(number, "I"))
				.replace("IIIII", "V")
				.replace("IIII", "IV")
				.replace("VV", "X")
				.replace("VIV", "IX")
				.replace("XXXXX", "L")
				.replace("XXXX", "XL")
				.replace("LL", "C")
				.replace("LXL", "XC")
				.replace("CCCCC", "D")
				.replace("CCCC", "CD")
				.replace("DD", "M")
				.replace("DCD", "CM");
	}
	
	/**
	 * Converts to int
	 * @param roman {@link String} of Roman Numeral
	 * @return converted
	 */
	public static final int toInteger(String roman) {
		int decimal = 0;
		int lastNumber = 0;
		for (char c : roman.toUpperCase().toCharArray()) {
			switch (c) {
			case 'M':
				decimal = processDecimal(1000, lastNumber, decimal);
				lastNumber = 1000;
				break;

			case 'D':
				decimal = processDecimal(500, lastNumber, decimal);
				lastNumber = 500;
				break;

			case 'C':
				decimal = processDecimal(100, lastNumber, decimal);
				lastNumber = 100;
				break;

			case 'L':
				decimal = processDecimal(50, lastNumber, decimal);
				lastNumber = 50;
				break;

			case 'X':
				decimal = processDecimal(10, lastNumber, decimal);
				lastNumber = 10;
				break;

			case 'V':
				decimal = processDecimal(5, lastNumber, decimal);
				lastNumber = 5;
				break;

			case 'I':
				decimal = processDecimal(1, lastNumber, decimal);
				lastNumber = 1;
				break;
			}
		}
		return decimal;
	}
	
	/**
	 * Helps {@link #toInteger(String)}<br>
	 * Converts char holding Roman Numeral to int
	 * 
	 * @param decimal Roman Numeral Unit
	 * @param lastNumber Roman Numeral Unit last processed
	 * @param lastDecimal converted number
	 * @return converted
	 */
	private static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
		if (lastNumber > decimal)
			return lastDecimal - decimal;
		return lastDecimal + decimal;
	}
}