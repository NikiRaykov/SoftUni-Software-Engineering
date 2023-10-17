import com.sun.jdi.DoubleValue;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        double money = 0;

        while (!command.equals("Start")){
            double coins = Double.parseDouble(command);

            if (coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2){
                money += coins;
            }else {
                System.out.printf("\nCannot accept %.2f\n", coins);
            }

            command = scanner.nextLine();
        }

        String product = scanner.nextLine();
         double change = 0.0;
        while (!product.equals("End")){
            // product = scanner.nextLine();
            double price = 0.0;

            if (product.equals("Nuts")){
                price += 2.0;
                if (price <= money){
                    System.out.print("Purchased Nuts\n");
                    money -= price;
                }else {
                    System.out.print("Sorry, not enough money\n");
                }
            }else if (product.equals("Water")){
                price += 0.7;
                if (price <= money){
                    System.out.print("Purchased Water\n");
                    money -= price;
                }else {
                    System.out.print("Sorry, not enough money\n");
                }
            }else if (product.equals("Crisps")){
                price += 1.5;
                if (price <= money){
                    System.out.print("Purchased Crisps\n");
                    money -= price;
                }else {
                    System.out.print("Sorry, not enough money\n");
                }
            }else if (product.equals("Soda")){
                price += 0.8;
                if (price <= money){
                    System.out.print("Purchased Soda\n");
                    money -= price;
                }else {
                    System.out.print("Sorry, not enough money\n");
                }
            }else if (product.equals("Coke")){
                price += 1.0;
                if (price <= money){
                    System.out.print("Purchased Coke\n");
                    money -= price;
                }else {
                    System.out.print("Sorry, not enough money\n");
                }
            }else {
                System.out.print("Invalid product\n");
            }

            product = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", money);
    }
}
