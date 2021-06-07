import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int digit; int sum = 0;
            int number = i;
            if (number >= 10) {
                while (number > 0) {
                    digit = number % 10;
                    number = number / 10;
                    sum += digit;
                }
            }else {
                sum += number;
            }

            if (sum == 5 || sum == 7 || sum == 11){
                System.out.printf("%d -> True%n", i);
            }else {
                System.out.printf("%d -> False%n", i);
            }
        }
    }
}
