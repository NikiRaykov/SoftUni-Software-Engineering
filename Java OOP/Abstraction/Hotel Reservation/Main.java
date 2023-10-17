import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] reservationInformation = scan.nextLine().split("\\s+");

        PriceCalculator calculator = new PriceCalculator(
                Double.parseDouble(reservationInformation[0]),
                Integer.parseInt(reservationInformation[1]),
                Season.valueOf(reservationInformation[2].toUpperCase()),
                reservationInformation[3].equals("SecondVisit")
                ? Discount.SECOND_VISIT
                : Discount.valueOf(reservationInformation[3].toUpperCase()));

        System.out.printf("%.2f", calculator.calculate());
    }
}
