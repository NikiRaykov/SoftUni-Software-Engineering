

import java.util.Scanner;

public class EasterShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int eggsInStore = Integer.parseInt(scanner.nextLine()); // the eggs that we have in the store

        boolean outOfEggs = false; boolean isClosed = false; int eggsSold = 0;

        String command = scanner.nextLine();
        while (!command.equals("Close")){
            //String buyOrFill = command;
            int eggsToBuyOrRefill = Integer.parseInt(scanner.nextLine()); // we choose how many eggs to buy or refill

            if (command.equals("Buy")){
                if (eggsToBuyOrRefill > eggsInStore){
                    outOfEggs = true;
                    break;
                }
                eggsInStore -= eggsToBuyOrRefill;
                eggsSold += eggsToBuyOrRefill;
            }else if (command.equals("Fill")){
                eggsInStore += eggsToBuyOrRefill;
            }

            command = scanner.nextLine();
        }

        if (outOfEggs){
            System.out.println("Not enough eggs in store!");
            System.out.printf("You can buy only %d.", eggsInStore);
        }else {
            System.out.println("Store is closed!");
            System.out.printf("%d eggs sold.", eggsSold);
        }
    }
}
