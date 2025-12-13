package nl.elros.controller;

import lombok.AllArgsConstructor;
import nl.elros.exception.UnsupportedMathOperationException;
import nl.elros.math.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static nl.elros.request.converter.NumberConverter.convertToDouble;

@RestController
@RequestMapping("/math")
@AllArgsConstructor
public class MathController {

    @Autowired
    private final MathUtil mathUtil;

    @RequestMapping("/sum/{num1}/{num2}")
    public ResponseEntity<Double> sum(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        double result = mathUtil.sum(convertToDouble(num1), convertToDouble(num2));
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/subtraction/{num1}/{num2}")
    public ResponseEntity<Double> subtraction(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        double result = mathUtil.subtraction(convertToDouble(num1), convertToDouble(num2));
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/multiplication/{num1}/{num2}")
    public ResponseEntity<Double> multiplication(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        double result = mathUtil.multiplication(convertToDouble(num1), convertToDouble(num2));
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/division/{num1}/{num2}")
    public ResponseEntity<Double> division(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        double num2Double = convertToDouble(num2);
        if (num2Double == 0) {
            throw new UnsupportedMathOperationException("Cannot divide by zero");
        }
        double result = mathUtil.division(convertToDouble(num1), num2Double);
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/mean/{num1}/{num2}")
    public ResponseEntity<Double> mean(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        double result = mathUtil.mean(convertToDouble(num1), convertToDouble(num2));
        return ResponseEntity.ok(result);
    }
}
