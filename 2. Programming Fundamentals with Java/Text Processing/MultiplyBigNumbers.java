import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num1 = scanner.nextLine();
        String num2 = scanner.nextLine();

        BigInteger number1 = new BigInteger(num1);
        BigInteger number2 = new BigInteger(num2);

        BigInteger result = number1.multiply(number2);
        System.out.println(result);
    }
}
