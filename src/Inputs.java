package src;

import java.util.*;

public class Inputs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);  // Set the locale to US to handle decimal point correctly
        List<String> operators = Arrays.asList("+", "-", "*", "/", "%", "min", "max");

        boolean restart = true;
        Calculator calculator = new Calculator(); // Create an instance of Calculator
        float lastResult = 0; // Variable to hold the last result

        // Main loop to handle the entire process
        while (restart) {
            float a = 0;
            float b = 0;
            String operator = "";
            boolean validNumbers = false;
            boolean validOperator = false;

            // Loop to handle number input
            while (!validNumbers) {
                try {
                    System.out.println("Enter first number (or 'restart all' to restart the entire process, 'restart numbers' to restart number input): ");
                    String input = sc.nextLine();
                    if (input.equalsIgnoreCase("restart all")) {
                        System.out.println("Restarting the entire process...");
                        continue; // Restart the main loop
                    }
                    if (input.equalsIgnoreCase("restart numbers")) {
                        System.out.println("Restarting number input...");
                        continue; // Restart the number input process
                    }
                    a = Float.parseFloat(input);

                    System.out.println("Enter second number (or 'restart all' to restart the entire process, 'restart numbers' to restart number input): ");
                    input = sc.nextLine();
                    if (input.equalsIgnoreCase("restart all")) {
                        System.out.println("Restarting the entire process...");
                        continue; // Restart the main loop
                    }
                    if (input.equalsIgnoreCase("restart numbers")) {
                        System.out.println("Restarting number input...");
                        continue; // Restart the number input process
                    }
                    b = Float.parseFloat(input);

                    validNumbers = true; // Numbers are valid
                } catch (NumberFormatException exception) {
                    System.out.println("Invalid input, please enter valid numbers or 'restart all' to restart the entire process or 'restart numbers' to restart number input.");
                }
            }

            // Loop to handle operator input
            while (!validOperator) {
                System.out.println("Please enter a valid operation (+, -, *, /, %, min/max) or 'restart all' to restart the entire process or 'restart numbers' to restart number input: ");
                operator = sc.nextLine();

                if (operator.equalsIgnoreCase("restart all")) {
                    System.out.println("Restarting the entire process...");
                    break; // Restart the main loop
                }
                if (operator.equalsIgnoreCase("restart numbers")) {
                    System.out.println("Restarting number input...");
                    validNumbers = false; // Reset to start number input again
                    break; // Exit the current loop and return to number input
                }

                if (operators.contains(operator)) {
                    validOperator = true; // Operator is valid
                } else {
                    System.out.println("Invalid operation, please try again or enter 'restart all' to restart the entire process or 'restart numbers' to restart number input.");
                }
            }
//            test
            // If the operator is valid, perform the calculation and print the results
            if (validOperator) {
                try {
                    lastResult = calculator.performOperation(a, b, operator);
                    System.out.println("Result: " + lastResult);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            // Set restart to false to end the process after one operation
            restart = false;
        }

        sc.close(); // Always close the Scanner when you're done
        System.out.println("Process completed.");
    }
}
