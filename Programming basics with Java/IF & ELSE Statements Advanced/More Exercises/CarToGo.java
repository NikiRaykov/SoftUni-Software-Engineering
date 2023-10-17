import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CarToGo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine(); // Summer or Winter
        String carType = "";
        double price = 0;
        String classType = "";

        if (budget <= 100) {
            classType = "Economy class";
            if (season.equals("Summer")){
                carType = "Cabrio";
                price = budget * 0.35;
            }
            else if (season.equals("Winter")) {
                carType = "Jeep";
                price = budget * 0.65;
            }
        }
        else if (budget <= 500){
            classType = "Compact class";
            if (season.equals("Summer")){
                carType = "Cabrio";
                price = budget * 0.45;
            }
            else if (season.equals("Winter")){
                carType = "Jeep";
                price = budget * 0.8;
            }
        }
        else {
            classType = "Luxury class";
            carType = "Jeep";
            price = budget * 0.9;
        }
        System.out.println(classType);
        System.out.printf("%s - %.2f", carType, price);
    }
}