import java.util.Scanner;

public class PrintAndSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int startNumber = Integer.parseInt(scanner.nextLine());
        int finalNumber = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = startNumber; i <= finalNumber ; i++) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.printf("\nSum: %d", sum);
    }
}
