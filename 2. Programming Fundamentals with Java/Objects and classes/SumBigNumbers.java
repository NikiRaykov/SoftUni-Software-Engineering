import java.math.BigInteger;
import java.util.Scanner;


//You will receive two numbers (0 to 1050), print their sum
public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger firstNumber = new BigInteger(scanner.next());
        BigInteger secondNumber = new BigInteger(scanner.next());

        BigInteger sum = firstNumber.add(secondNumber);
        System.out.println(sum);
    }
}
