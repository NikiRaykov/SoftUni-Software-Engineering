import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());

        double result = factorialDivision(number1, number2);
        System.out.printf("%.2f", result);

    }
    public static int factorialDivision(int number1, int number2){
        for (int i = number1; i > 1; i--) {
            number1 *= i - 1;
        }

        for (int i = number2; i > 1; i--) {
            number2 *= i - 1;
        }
        return number1 / number2;
    }
}
