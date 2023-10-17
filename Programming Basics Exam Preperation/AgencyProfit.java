import java.util.Scanner;

public class AgencyProfit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String companyName = scanner.nextLine();
        int adultTickets = Integer.parseInt(scanner.nextLine());
        int childrenTickets = Integer.parseInt(scanner.nextLine());
        double adultTicketPrice = Double.parseDouble(scanner.nextLine());
        double tax = Double.parseDouble(scanner.nextLine());


        double childrenTicketPriceNet = 0;
        double adultTicketFinalPrice = 0;
        double wholeSum = 0;
        double profit = 0;

        childrenTicketPriceNet = (adultTicketPrice * 0.30) + tax;
        adultTicketFinalPrice = adultTicketPrice + tax;
        wholeSum = (adultTickets * adultTicketFinalPrice) + (childrenTickets * childrenTicketPriceNet);
        profit = wholeSum * 0.20;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.",companyName, profit);
    }
}


