import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double ticketsPrice = 0;

        double budget = Double.parseDouble(scanner.nextLine());
        String ticketCategory = scanner.nextLine(); // VIP or Normal
        int friendsNumber = Integer.parseInt(scanner.nextLine());

        double budgetLeft = 0;

        if (friendsNumber >= 1 && friendsNumber <= 4){
            budgetLeft = budget * 0.25;
        }
        else if (friendsNumber <= 9){
            budgetLeft = budget * 0.4;
        }
        else if (friendsNumber <= 24){
            budgetLeft = budget * 0.5;
        }
        else if (friendsNumber <= 49){
            budgetLeft = budget * 0.6;
        }
        else {
            budgetLeft = budget * 0.75;
        }

        if (ticketCategory.equals("VIP")){
            ticketsPrice = friendsNumber * 499.99;
        }
        else if (ticketCategory.equals("Normal")){
            ticketsPrice = friendsNumber * 249.99;
        }

        if (budgetLeft >= ticketsPrice){
            System.out.printf("Yes! You have %.2f leva left.", budgetLeft - ticketsPrice);
        }
        else {
            System.out.printf("Not enough money! You need %.2f leva.", ticketsPrice - budgetLeft);
        }
    }
}