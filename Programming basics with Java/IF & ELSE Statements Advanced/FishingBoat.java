import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fisherMen = Integer.parseInt(scanner.nextLine());
        double price = 0.0;

        switch (season){
            case "Spring":
                price = 3000;
                break;

            case "Autumn":
            case "Summer":
                price = 4200;
                break;

            case "Winter":
                price = 2600;
                break;
        }

        if (fisherMen <=6){
            price = price * 0.9;
        }else if (fisherMen <= 11){
            price = price * 0.85;
        }else{
            price = price * 0.75;
        }

        if (fisherMen % 2 == 0 && !season.equals("Autumn")){
            price = price * 0.95;
        }

        if (price <= budget){
            System.out.printf("Yes! You have %.2f leva left.", budget - price);
        }
        else{
            System.out.printf("Not enough money! You need %.2f leva.", Math.abs(price - budget));
        }
    }
}
