package nl.elros.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{num1}/{num2}")
    public ResponseEntity<Double> sum(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {
        double result;

        try {
            result = Double.parseDouble(num1) + Double.parseDouble(num2);
        } catch (NumberFormatException e) {
            throw new UnsupportedOperationException("Please set a numeric value");
        }

        return ResponseEntity.ok(result);
    }
}
