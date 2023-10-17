import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double totalPlunder = 0.0;

        for (int day = 1; day <= days; day++) {
            totalPlunder += dailyPlunder;
            if (day % 3 == 0) {
                totalPlunder += 0.5 * dailyPlunder;
            }

            if (day % 5 == 0) {
                totalPlunder = 0.7 * totalPlunder;
            }
        }

        if (totalPlunder >= expectedPlunder){
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        }else {
            System.out.printf("Collected only %.2f%% of the plunder.", (totalPlunder/expectedPlunder) * 100);
        }
    }
}
