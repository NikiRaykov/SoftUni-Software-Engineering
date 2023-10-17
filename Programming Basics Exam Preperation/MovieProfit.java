import java.util.Scanner;

public class MovieProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movieName = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        int tickets = Integer.parseInt(scanner.nextLine());
        double ticketPrice = Double.parseDouble(scanner.nextLine());
        double profitForTheCinema = Double.parseDouble(scanner.nextLine());

        double profitFromTicketsForADay = tickets * ticketPrice;
        double profitForWholePeriod = profitFromTicketsForADay * days;
        double moneyForTheCinema = profitForWholePeriod * (profitForTheCinema / 100.0f);
        double profit = profitForWholePeriod - moneyForTheCinema;
        System.out.printf("The profit from the movie %s is %.2f lv.", movieName, profit);

    }
}
