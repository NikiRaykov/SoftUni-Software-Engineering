import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int penPackets = Integer.parseInt(scanner.nextLine());
        int markersPackets = Integer.parseInt(scanner.nextLine());
        double liters = Double.parseDouble(scanner.nextLine());
        int discount = Integer.parseInt(scanner.nextLine());

        double budget;
        double penPrice;
        double markersPrice;
        double litersPrice;

        penPrice = penPackets * 5.80;
        markersPrice = markersPackets * 7.20;
        litersPrice = liters * 1.20;

        budget = penPrice + markersPrice + litersPrice;
        budget = budget - ((budget * discount)/100);

        System.out.printf("%.3f", budget);
    }
}