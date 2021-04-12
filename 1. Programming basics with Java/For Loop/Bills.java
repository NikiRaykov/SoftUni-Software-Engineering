import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int months = Integer.parseInt(scanner.nextLine());
        double waterPrice = 20; // 20
        double internetPrice = 15; // 15
        double other = 0.0;
        double electricityBill = 0;
        double water = 0;
        double internet = 0;
        double additionalExpenses = 0;
        double other1 = 0;

        for (int i = 0; i < months; i++) {
            double electricity = Double.parseDouble(scanner.nextLine());
            electricityBill += electricity;

            water = months * waterPrice;
            internet = months * internetPrice;

            other1 = electricity + waterPrice + internetPrice;
            other = ((electricity + waterPrice + internetPrice) / 100) * 20;
            additionalExpenses += other1 + other;

        }
        System.out.printf("Electricity: %.2f lv%n", electricityBill);
        System.out.printf("Water: %.2f lv%n", water);
        System.out.printf("Internet: %.2f lv%n", internet);
        System.out.printf("Other: %.2f lv%n", additionalExpenses);
        System.out.printf("Average: %.2f lv", (electricityBill+ water + internet + additionalExpenses) / months);
    }
}
