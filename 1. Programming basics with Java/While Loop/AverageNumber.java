import java.util.Scanner;

public class AverageNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 0; i < number; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            sum += currentNumber;
        }

        double average = sum * 1.0 / number;
        System.out.printf("%.2f%n", average);
    }
}
