import java.util.Scanner;

public class CharityCampaign {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                double cakePrice = 45;
                double wafflePrice = 5.80;
                double pankacePrice = 3.20;

                int days = Integer.parseInt(scanner.nextLine());
                int chefs = Integer.parseInt(scanner.nextLine());
                int cakes = Integer.parseInt(scanner.next());
                int waffles = Integer.parseInt(scanner.next());
                int pancakes = Integer.parseInt(scanner.next());

                double cakesSum = cakePrice * cakes;
                double wafflesSum = wafflePrice * waffles;
                double pankakesSum = pankacePrice * pancakes;

                double wholeSumFromChefsForAday = (cakesSum + wafflesSum + pankakesSum) * chefs;
                double sumFromCampany = wholeSumFromChefsForAday * days;
                double sumAfterExpenses = sumFromCampany - (sumFromCampany / 8.0);

                System.out.printf("%2f", sumAfterExpenses);
        }
}