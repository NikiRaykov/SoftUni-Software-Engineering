import java.util.Scanner;

public class CareOfPuppy {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int food = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int foodGr = 0; int foodEaten = 0;

        while (!command.equals("Adopted")){
            int gramsEatenPerDay = Integer.parseInt(command);

            // convert kg to grams
            foodGr = food * 1000;

            // whole food eaten
            foodEaten += gramsEatenPerDay;

            command = scanner.nextLine();
        }


        if (foodEaten <= foodGr){
            System.out.printf("Food is enough! Leftovers: %d grams.", foodGr - foodEaten);
        }
        else {
            System.out.printf("Food is not enough. You need %d grams more.", foodEaten - foodGr);
        }
    }
}