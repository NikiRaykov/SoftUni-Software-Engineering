import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine()); // days that she is gone
        int foodInKg = Integer.parseInt(scanner.nextLine()); // food left

        double dogFood = Double.parseDouble(scanner.nextLine()); // for a day
        double catFood = Double.parseDouble(scanner.nextLine());  // for a day
        double turtleFood = Double.parseDouble(scanner.nextLine()); // for a day
        double wholeFood = 0;

        double dog = dogFood * days;
        double cat = catFood * days;
        double turtle = (turtleFood * days) / 1000;

        wholeFood = dog + cat + turtle;

        if (wholeFood < foodInKg){
            System.out.printf("%.0f kilos of food left.", Math.floor(foodInKg - wholeFood));
        }
        else {
            System.out.printf("%.0f more kilos of food are needed.", (Math.ceil(wholeFood - foodInKg)));
        }
    }
}
