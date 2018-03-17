package sis.util;

import java.math.BigDecimal;
import java.util.List;

public class StringUtil {
    static final String SUBSTRING_CANNOT_BE_EMPTY = "Substring cannot be empty";
    public static int occurrences(String string, String substring) {
	if (substring.isEmpty())
	    throw new IllegalArgumentException(SUBSTRING_CANNOT_BE_EMPTY);

	if (!string.contains(substring)) {
	    return 0;
	}
	else {
	    return 1 + occurrences(getSuffix(string, substring), substring);
	}
    }

    private static String getSuffix(String string, String substring) {
	return string.split(substring, 2)[1];
    }

    static String concatenate(List<?> list) {
	if (list == null) return "";

	StringBuilder result = new StringBuilder();
	for (Object element: list)
	    result.append(addNewline(element));
	return result.toString();
    }

    private static String addNewline(Object element) {
	return String.format("%s%n", element.toString());
    }

    static String concatenateNumbers(List<? extends Number> list, int decimalPlaces) {
	if (list == null) return "";

	StringBuilder result = new StringBuilder();
	for (Number number: list)
	    result.append(formatNumber(number, decimalPlaces));
	return result.toString();
    }

    private static String formatNumber(Number number, int decimalPlaces) {
	String format = String.format("%%.%df%%n", decimalPlaces);
	return String.format(format, number.doubleValue());
    }

}
