package nl.elros.math;

import org.springframework.stereotype.Service;

@Service
public class MathUtil {

    public double sum(double num1, double num2) {
        return num1 + num2;
    }

    public double subtraction(double num1, double num2) {
        return num1 - num2;
    }

    public double multiplication(double num1, double num2) {
        return num1 * num2;
    }

    public double division(double num1, double num2) {
        return num1 / num2;
    }

    public double mean(double num1, double num2) {
        return (num1 + num2) / 2;
    }
}
