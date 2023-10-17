import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] len = scanner.nextLine().split(" ");
        int[] numbers = new int[len.length]; int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(len[i]);
        }

        for (int number : numbers) {
            if (number % 2 == 0) {
                sum += number;
            }
        }
    }
}
