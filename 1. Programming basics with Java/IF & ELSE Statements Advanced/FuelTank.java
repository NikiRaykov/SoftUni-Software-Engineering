import java.util.Locale;
import java.util.Scanner;

public class FuelTank {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine();
        int fuel = Integer.parseInt(scanner.nextLine());

        switch (fuelType){
            case "Diesel":
            case "Gasoline":
            case "Gas":
                if (fuel >= 25){
                    System.out.printf("You have enough %s.", fuelType.toLowerCase());
                }
                else{
                    System.out.printf("Fill your tank with %s!", fuelType.toLowerCase());
                }

                break;

            default:
                System.out.println("Invalid fuel!");
                break;
        }
    }
}
