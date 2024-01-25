import java.util.*;

class Calculator {
    private long result;

    public void add(long numOne, long numTwo) {
        result = numOne + numTwo;
        System.out.println("Your result is: " + result);
    }

    public void subtract(long numOne, long numTwo) {
        result = numOne - numTwo;
        System.out.println("Your result is: " + result);
    }

    public void multiply(long numOne, long numTwo) {
        result = numOne * numTwo;
        System.out.println("Your result is: " + result);
    }

    public void divide(long numOne, long numTwo) {
        if (numTwo == 0) {
            System.out.println("cannot divide by 0");
        } else {
            float divisionResult = numOne/ (float) numTwo;
            System.out.println("Your result is: " + divisionResult);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        // variables for storing the two numbers and the result of operation
        long numOne = 0, numTwo = 0, result;
        // variables for storing sign and userResponse when asked whether they want to perform more calculations
        String sign = "", userResponse;
        // variable is kinda like the exit button of the calculator
        boolean programState = true;

        // Scanner object for accepting user input
        Scanner userInput = new Scanner(System.in);
        // creating calculator object
        Calculator calculator = new Calculator();

        while (programState) {

            boolean userInputIsInvalid = true;

            while (userInputIsInvalid) {
                try {
                    System.out.println("Enter first number: ");
                    numOne = userInput.nextLong();
                    userInputIsInvalid = false;
                } catch (Exception checkIfInputIsANumber) {
                    System.out.println("Input must be a number");
                    System.out.println("");
                    userInput.nextLine();
                }
            }

            userInputIsInvalid = true;

            while (userInputIsInvalid) {
               System.out.println("Enter sign: ");
               sign = userInput.next();

               if (sign.contentEquals("+") | sign.contentEquals("/") | sign.contentEquals("-") | sign.contentEquals("*") ) {
                   userInputIsInvalid = false;
               } else {
                   System.out.println("Input a valid sign");
                   System.out.println("");
               }
            }

            userInputIsInvalid = true;

            while (userInputIsInvalid) {
                try {
                    System.out.println("Enter second number: ");
                    numTwo = userInput.nextLong();
                    userInputIsInvalid = false;
                } catch (Exception checkIfInputIsANumber) {
                    System.out.println("Input must be a number");
                    System.out.println("");
                    userInput.nextLine();
                }
            }

            if (sign.equals("+")) {
                calculator.add(numOne, numTwo);
            } else if (sign.equals("-")) {
                calculator.subtract(numOne, numTwo);
            } else if (sign.equals("*")) {
                calculator.multiply(numOne, numTwo);
            } else if (sign.equals("/")) {
                calculator.divide(numOne, numTwo);
            }

            userInputIsInvalid = true;
            while (userInputIsInvalid){
                System.out.println("");
                System.out.println("Do you wish to continue calculating? Type Y for yes or N for no");
                userResponse = userInput.next().replaceAll("\\s+","");

                if (userResponse.equals("y") | userResponse.equals("Y")) {
                    userInputIsInvalid = false;
                } else if (userResponse.equals("n") | userResponse.equals("N")) {
                    programState = false;
                    userInputIsInvalid = false;
                } else {
                    System.out.println("Input must either be Y or N");
                }
            }

        }

    }
}