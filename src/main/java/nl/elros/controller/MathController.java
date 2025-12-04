package nl.elros.controller;

import nl.elros.exception.UnsupportedMathOperationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{num1}/{num2}")
    public ResponseEntity<Double> sum(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        double result = convertToDouble(num1) + convertToDouble(num2);
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/subtraction/{num1}/{num2}")
    public ResponseEntity<Double> subtraction(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        double result = convertToDouble(num1) - convertToDouble(num2);
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/multiplication/{num1}/{num2}")
    public ResponseEntity<Double> multiplication(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        double result = convertToDouble(num1) * convertToDouble(num2);
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/division/{num1}/{num2}")
    public ResponseEntity<Double> division(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        double num2Double = convertToDouble(num2);
        if (num2Double == 0) {
            throw new UnsupportedMathOperationException("Cannot divide by zero");
        }
        double result = convertToDouble(num1) / num2Double;
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/mean/{num1}/{num2}")
    public ResponseEntity<Double> mean(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        double result = (convertToDouble(num1) + convertToDouble(num2)) / 2;
        return ResponseEntity.ok(result);
    }

    private double convertToDouble(String strNumber) {
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
