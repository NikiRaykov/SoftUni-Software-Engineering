import java.util.Scanner;

public class VetParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysParked = Integer.parseInt(scanner.nextLine());
        int hoursPerDay = Integer.parseInt(scanner.nextLine());

        double taxPaid = 0; double totalSumPaid = 0;

        for (int i = 1; i <= daysParked; i++) {
            taxPaid = 0;
            for (int j = 1; j <= hoursPerDay; j++) {
                if (i % 2 == 0){ // even
                    if (j % 2 != 0){
                        taxPaid += 2.50;
                    }else {
                        taxPaid++;
                    }
                }

                if (i % 2 != 0){ // odd
                    if (j % 2 == 0){
                        taxPaid += 1.25;
                    }else {
                        taxPaid++;
                    }
                }
            }
            totalSumPaid += taxPaid;
            System.out.printf("Day: %d - %.2f leva\n", i, taxPaid);
        }
        System.out.printf("Total: %.2f leva", totalSumPaid);
    }
}
