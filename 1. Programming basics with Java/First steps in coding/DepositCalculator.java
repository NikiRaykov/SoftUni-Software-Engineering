import java.util.Scanner;

public class DepositCalculator {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                double DepositSum = Double.parseDouble(scanner.nextLine());
                int months = Integer.parseInt(scanner.nextLine());
                double interestRate = Double.parseDouble(scanner.nextLine());

                double interest = (DepositSum * interestRate / 100);
                double sumPerMonth = interest / 12;
                double totalSum = DepositSum + months * sumPerMonth;
                System.out.println(totalSum);

        }
}
