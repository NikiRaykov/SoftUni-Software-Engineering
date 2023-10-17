import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        double s = Double.parseDouble(scanner.nextLine());

        if (town.equals("Sofia")) {
            if (s <= 500) {
                System.out.printf("%.2f", s * (5.0f/100.0f));
            } else if (s > 500 && s <= 1000) {
                System.out.printf("%.2f", s * (7.0f/100.0f));
            } else if (s > 1000 && s <= 10000) {
                System.out.printf("%.2f", s * (8.0f/100.0f));
            } else if (s > 10000) {
                System.out.printf("%.2f", s * (12.0f/100.0f));
            }
        }
        if (town.equals("Varna")) {
            if (s <= 500) {
                System.out.printf("%.2f", s * (4.5f/100.0f));
            } else if (s > 500 && s <= 1000) {
                System.out.printf("%.2f", s * (7.5f/100.0f));
            } else if (s > 1000 && s <= 10000) {
                System.out.printf("%.2f", s * (10.0f/100.0f));
            } else if (s > 10000) {
                System.out.printf("%.2f", s * (13.0f/100.0f));
            }
        }
        if (town.equals("Plovdiv")) {
            if (s <= 500) {
                System.out.printf("%.2f", s * (5.5f/100.0f));
            } else if (s > 500 && s <= 1000) {
                System.out.printf("%.2f", s * (8.0f/100.0f));
            } else if (s > 1000 && s <= 10000) {
                System.out.printf("%.2f", s * (12.0f/100.0f));
            } else if (s > 10000) {
                System.out.printf("%.2f",s * (14.5f/100.0f));
            }
        }
    }

}
