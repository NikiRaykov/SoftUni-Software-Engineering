import java.util.Scanner;

public class CatWalking {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int minPerDay = Integer.parseInt(scanner.nextLine());
        int walksPerDay = Integer.parseInt(scanner.nextLine());
        int caloriesPerDay = Integer.parseInt(scanner.nextLine());

        double minutesWalked = 0;
        double burnedCalories = 0;
        double halfOfTheCalories = 0;

        minutesWalked = walksPerDay * minPerDay;
        burnedCalories = (int)(minutesWalked * 5);
        halfOfTheCalories = caloriesPerDay * 0.5;

        if (burnedCalories >= halfOfTheCalories){
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %.0f.", burnedCalories);
        }
        else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %.0f.", burnedCalories);
        }
    }
}