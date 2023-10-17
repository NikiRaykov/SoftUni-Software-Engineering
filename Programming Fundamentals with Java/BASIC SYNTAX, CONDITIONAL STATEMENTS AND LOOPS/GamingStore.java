import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = Double.parseDouble(scanner.nextLine());

        double OutFall4Price = 39.99;
        double CSOGprice = 15.99;
        double ZplinterZellPrice = 19.99;
        double Honored2price = 59.99;
        double RoverWatchPrice = 29.99;
        double RoverWatchOriginsEditionPrice = 39.99;

        double totalSpent = 0.0;

        String input = scanner.nextLine();

        while (!input.equals("Game Time")){

            if (input.equals("RoverWatch")){
                if (balance >= RoverWatchPrice){
                    balance -= RoverWatchPrice;
                    totalSpent += RoverWatchPrice;
                    System.out.println("Bought RoverWatch");
                    if (balance == 0.0){
                        System.out.println("Out of money!");
                        return;
                    }
                }else {
                    System.out.println("Too Expensive");
                }
            }else if (input.equals("OutFall 4")){
                if (balance >= OutFall4Price){
                    balance -= OutFall4Price;
                    totalSpent += OutFall4Price;
                    System.out.println("Bought OutFall 4");
                    if (balance == 0.0){
                        System.out.println("Out of money!");
                        return;
                    }
                }else {
                    System.out.println("Too Expensive");
                }
            }else if (input.equals("CS: OG")){
                if (balance >= CSOGprice){
                    balance -= CSOGprice;
                    totalSpent += CSOGprice;
                    System.out.println("Bought CS: OG");
                    if (balance == 0.0){
                        System.out.println("Out of money!");
                        return;
                    }
                }else {
                    System.out.println("Too Expensive");
                }
            }else if (input.equals("Zplinter Zell")){
                if (balance >= ZplinterZellPrice){
                    balance -= ZplinterZellPrice;
                    totalSpent += ZplinterZellPrice;
                    System.out.println("Bought Zplinter Zell");
                    if (balance == 0.0){
                        System.out.println("Out of money!");
                        return;
                    }
                }else {
                    System.out.println("Too Expensive");
                }
            }else if (input.equals("Honored 2")){
                if (balance >= Honored2price){
                    balance -= Honored2price;
                    totalSpent += Honored2price;
                    System.out.println("Bought Honored 2");
                    if (balance == 0.0){
                        System.out.println("Out of money!");
                        return;
                    }
                }else {
                    System.out.println("Too Expensive");
                }
            }else if (input.equals("RoverWatch Origins Edition")){
                if (balance >= RoverWatchOriginsEditionPrice){
                    balance -= RoverWatchOriginsEditionPrice;
                    totalSpent += RoverWatchOriginsEditionPrice;
                    System.out.println("Bought RoverWatch Origins Edition");
                    if (balance == 0.0){
                        System.out.println("Out of money!");
                        return;
                    }
                }else {
                    System.out.println("Too Expensive");
                }
            }else {
                System.out.println("Not Found");
            }

            input = scanner.nextLine();
        }
        System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, balance);
    }
}
