import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0; int asciiValue = 0;

        for (int i = 1; i <= n; i++) {
            char letters = scanner.next().charAt(0);
            asciiValue = (int)letters;
            sum += asciiValue;
        }

        System.out.printf("The sum equals: %d", sum);
    }
}
