import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");
        int[] numbers = new int[line.length]; int evenSum = 0; int oddSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenSum += number;
            } else {
                oddSum += number;
            }
        }
        System.out.println(evenSum - oddSum);
    }
}
