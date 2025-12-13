package nl.elros.request.converter;

import nl.elros.exception.UnsupportedMathOperationException;

public class NumberConverter {

    public static double convertToDouble(String strNumber) {
        if (strNumber == null) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        String number = strNumber.replaceAll(",", ".");
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
    }
}
