import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int km = Integer.parseInt(scanner.nextLine());
        String dayOrNight = scanner.nextLine();

        double price = 0.0;

        if (km <= 20 && dayOrNight.equals("day")) {
            price = 0.70 + (0.79 * km);
            System.out.printf("%.2f", price);
        } else if (km <= 20 && dayOrNight.equals("night")) {
            price = 0.70 + (0.90 * km);
            System.out.printf("%.2f", price);
        } else if (km >= 20 && km <= 100 && dayOrNight.equals("day")) {
            price = 0.09 * km;
            System.out.printf("%.2f", price);
        } else if (km >= 20 && km <= 100 && dayOrNight.equals("night")) {
            price = 0.09 * km;
            System.out.printf("%.2f", price);
        } else if (km >= 100 && dayOrNight.equals("day")) {
            price = 0.06 * km;
            System.out.printf("%.2f", price);
        } else if (km >= 100 && dayOrNight.equals("night")) {
            price = 0.06 * km;
            System.out.printf("%.2f", price);
        }
    }
}