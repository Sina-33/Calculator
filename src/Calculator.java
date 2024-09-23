package src;

public class Calculator {
    // Method to perform operations
    public float performOperation(float a, float b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b != 0) {
                    return a / b;
                } else {
                    throw new ArithmeticException("Cannot divide by zero");
                }
            case "%":
                return a % b;
            case "min":
                return Math.min(a, b);
            case "max":
                return Math.max(a, b);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
