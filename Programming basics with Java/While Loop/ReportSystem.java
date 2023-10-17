import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int goalSum = Integer.parseInt(scanner.nextLine());
        double cashPayments = 0.0;
        double cardPayments = 0.0;
        int counter = 0;
        double sum;
        double counterCash = 0.0;
        double counterCard = 0.0;

        String command = scanner.nextLine();

        while (!command.equals("End")){
            int price = Integer.parseInt(command);
            counter++;

            if (counter % 2 != 0){
                if (price >= 100){
                    System.out.println("Error in transaction!");
                }
                else {
                    System.out.println("Product sold!");
                    cashPayments += price;
                    counterCash++;
                }
            }

            if (counter % 2 == 0){
                if (price <= 10){
                    System.out.println("Error in transaction!");
                }
                else {
                    System.out.println("Product sold!");
                    cardPayments += price;
                    counterCard++;
                }
            }

            sum = cashPayments + cardPayments;

            if (sum >= goalSum){
                System.out.printf("Average CS: %.2f%n", cashPayments / counterCash);
                System.out.printf("Average CC: %.2f", cardPayments / counterCard);
                break;
            }
            command = scanner.nextLine();
        }

        if (command.equals("End")){
            System.out.println("Failed to collect required money for charity.");
        }
    }
}
