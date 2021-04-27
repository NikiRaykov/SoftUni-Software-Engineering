import java.util.Scanner;

public class Safari {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double fuelLiters = Double.parseDouble(scanner.nextLine());
        String dayOfTheWeekend = scanner.nextLine();

        double fuelAndTourGuidePrice = (fuelLiters * 2.10) + 100;

        if (dayOfTheWeekend.equals("Saturday")){
            fuelAndTourGuidePrice -= fuelAndTourGuidePrice * (10.0f/100.0f);
        }else if (dayOfTheWeekend.equals("Sunday")){
            fuelAndTourGuidePrice -= fuelAndTourGuidePrice * (20.0f/100.0f);
        }

        if (budget >= fuelAndTourGuidePrice){
            System.out.printf("Safari time! Money left: %.2f lv.", budget - fuelAndTourGuidePrice);
        }else {
            System.out.printf("Not enough money! Money needed: %.2f lv.", fuelAndTourGuidePrice - budget);
        }
    }
}
