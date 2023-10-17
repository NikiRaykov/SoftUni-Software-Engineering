import java.util.Arrays;
import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int numbersCount = (int) Arrays.stream(numbers).count();
        System.out.println("Count = " + numbersCount);

        int sum = Arrays.stream(numbers).sum();
        System.out.println("Sum = " + sum);
    }
}
