import java.time.temporal.IsoFields;
import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine(); // Spring, Summer, Autumn, Winter
        double kmPerMonth = Double.parseDouble(scanner.nextLine());

        double salary = 0;

        switch (season) {
            case "Spring":
            case "Autumn":
                if (kmPerMonth <= 5000){
                    salary = 4 * (kmPerMonth * 0.75) * 0.9;
                }
                else if (kmPerMonth <= 10000){
                    salary = 4 * (kmPerMonth * 0.95) * 0.9;
                }
                else if (kmPerMonth <= 20000){
                    salary = 4 * (kmPerMonth * 1.45) * 0.9;
                }
                break;
            case "Summer":
                if (kmPerMonth <= 5000){
                    salary = 4 * (kmPerMonth * 0.90) * 0.9;
                }
                else if (kmPerMonth <= 10000){
                    salary = 4 * (kmPerMonth * 1.10) * 0.9;
                }
                else if (kmPerMonth <= 20000){
                    salary = 4 * (kmPerMonth * 1.45) * 0.9;
                }
                break;

            case "Winter":
                if (kmPerMonth <= 5000){
                    salary = 4 * (kmPerMonth * 1.05) * 0.9;
                }
                else if (kmPerMonth <= 10000){
                    salary = 4 * (kmPerMonth * 1.25) * 0.9;
                }
                else if (kmPerMonth <= 20000){
                    salary = 4 * (kmPerMonth * 1.45) * 0.9;
                }
                break;
        }
        System.out.printf("%.2f", salary);
    }
}
