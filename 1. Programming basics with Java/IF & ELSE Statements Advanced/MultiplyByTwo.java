import java.util.Scanner;

public class MultiplyByTwo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double currentNum = Double.parseDouble(scanner.nextLine());
        double result = 0.0;

        while (currentNum >= 0){
            result = currentNum * 2;
            System.out.printf("Result: %.2f%n", result);

            currentNum = Double.parseDouble(scanner.nextLine());
            }
        if (currentNum < 0){
            System.out.println("Negative number!");
        }

    }
}
