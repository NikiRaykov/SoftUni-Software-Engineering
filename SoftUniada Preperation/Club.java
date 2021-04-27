import java.util.Scanner;

public class Club {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double wantedProfit = Double.parseDouble(scanner.nextLine());

        String cocktail = scanner.nextLine();
        double currentProfit = 0; boolean targetAcquired = false; double profit = 0;

        while (!cocktail.equals("Party!")){
            int cocktailsOrder = Integer.parseInt(scanner.nextLine());
            currentProfit = 0;

            currentProfit += cocktailsOrder * cocktail.length();
            if (currentProfit % 2 != 0){
                currentProfit -= currentProfit * (25.0f/100.0f);
            }

            profit += currentProfit;

            if (profit >= wantedProfit){
                targetAcquired = true;
                break;
            }
            cocktail = scanner.nextLine();
        }

        if (targetAcquired){
            System.out.println("Target acquired.");
        }else {
            System.out.printf("We need %.2f leva more.%n", wantedProfit - profit);
        }
        System.out.printf("Club income - %.2f leva.", profit);
    }
}
