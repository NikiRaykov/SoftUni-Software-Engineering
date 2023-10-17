import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int secondNumber = Integer.parseInt(scanner.nextLine());

       double result =  mathOperation(firstNumber, secondNumber, operator);
        System.out.printf("%.0f", result);
    }

    private static double mathOperation(int firstNumber, int secondNumber, String operator){
        double result = 0.0;

        switch (operator){
            case "/":
                result = firstNumber / secondNumber;
                break;

            case "+":
                result = firstNumber + secondNumber;
                break;

            case "*":
                result = firstNumber * secondNumber;
                break;

            case "-":
                result = firstNumber - secondNumber;
                break;
        }
            return  result;
    }
}
