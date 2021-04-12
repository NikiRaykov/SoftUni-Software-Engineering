import java.util.Scanner;

public class RefactorSumOfOddNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 1;
        for (int i = 0; i <=n; i++) {
            System.out.println(2 * i + 1);
            sum += i;
        }
        System.out.printf("Sum: %d%n", sum);
    }
}
