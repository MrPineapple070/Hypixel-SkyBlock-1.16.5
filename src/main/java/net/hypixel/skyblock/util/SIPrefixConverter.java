package net.hypixel.skyblock.util;

import java.text.ParseException;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;

/**
 * Converts SI Prefixes into int and long<br>
 * Due to varying levels of precision with these number types, certain prefixes
 * will and will not be supported.<br>
 * Please view each method's comments to see which prefixes are supported by
 * each method.<br>
 * Each input for the method should match with "[0-9]+\x20+[E|P|T|G|M|k|h|da]".
 * 
 * @author MrPineapple070
 * @version 11 July 2019
 * @since 11 July 2019
 */
public class SIPrefixConverter {
	/**
	 * {@link String} holding the regex to valid prefixes for an int
	 */
	@Nonnull
	private static final String regex_int = "G|M|k|h|da";

	/**
	 * {@link String} holding the regex to valid prefixes for a long.
	 */
	@Nonnull
	private static final String regex_long = "E|P|T|G|M|k|h|da";

	/**
	 * Converts into an int.<br>
	 * Supported Prefixes are giga (G), mega (M), kilo (k), hecto (h), deca
	 * (da).<br>
	 * Given {@link Integer#MAX_VALUE} is {@value Integer#MAX_VALUE}, 2G should be
	 * the largest inputed value.
	 * 
	 * @param SI {@link String}
	 * @return converted integer
	 * @throws ParseException if inputed {@link String} fails to meet requirements.
	 */
	public static final int toInt(String SI) throws ParseException {
		String[] split = SI.split("\\s+");
		if (split.length == 1)
			throw new ParseException("Inputed value must contain at least one space", -1);
		float num = Float.parseFloat(split[0]);
		if (num == 0)
			return 0;
		if (!Pattern.matches(regex_int, split[1]))
			throw new ParseException("Inputed value does not contain supported prefixes.", -1);
		if (split[1].length() == 1) {
			char prefix = split[1].charAt(0);
			switch (prefix) {
			case 'G':
				return (int) (num * 1000000000);
			case 'M':
				return (int) (num * 1000000);
			case 'k':
				return (int) (num * 1000);
			case 'h':
				return (int) (num * 100);
			}
		}
		return (int) (num * 10);
	}

	/**
	 * Converts into a long.<br>
	 * Supported Prefixes are exa (E), peta (P), tera (T), giga (G), mega (M), kilo
	 * (k), hecto (h), deca (da).<br>
	 * Given {@link Integer#MAX_VALUE} is {@value Integer#MAX_VALUE}, 2G should be
	 * the largest inputed value.
	 * 
	 * @param SI {@link String}
	 * @return converted long
	 * @throws ParseException if inputed {@link String} fails to meet requirements.
	 */
	public static final long toLong(String SI) throws ParseException {
		String[] split = SI.split("\\s+");
		if (split.length == 1)
			throw new ParseException("Inputed value must contain at least one space", -1);
		float num = Float.parseFloat(split[0]);
		if (num == 0)
			return 0;
		if (!Pattern.matches(regex_int, split[1]))
			throw new ParseException("Inputed value does not contain supported prefixes.", -1);
		if (split[1].length() == 1) {
			char prefix = split[1].charAt(0);
			switch (prefix) {
			case 'E':
				return (long) (num * 1000000000000000000l);
			case 'P':
				return (long) (num * 1000000000000000l);
			case 'T':
				return (long) (num * 1000000000000l);
			case 'G':
				return (long) (num * 1000000000l);
			case 'M':
				return (long) (num * 1000000l);
			case 'k':
				return (long) (num * 1000l);
			case 'h':
				return (long) (num * 100l);
			}
		}
		return (long) (num * 10l);
	}
}