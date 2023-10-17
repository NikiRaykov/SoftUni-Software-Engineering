import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int soapBottles = Integer.parseInt(scanner.nextLine());
        int soap = soapBottles * 750; // whole soup
        int dishesSoap = 0; // soup that we use

        int i = 0;
        int dish = 0;
        int pots = 0;

        String command = scanner.nextLine();

        while (!command.equals("End")){
            int dishes = Integer.parseInt(command);
            i++;

            if (i % 3 == 0){
                dishesSoap = dishes * 15;
                pots += dishes; // бройка тенджери
            }
            if (i % 3 != 0) {
                dishesSoap = dishes * 5;
                dish +=dishes; // бройка чинии
            }

            if (soap < dishesSoap){
                break;
            }
            soap -= dishesSoap;
            command = scanner.nextLine();
        }
        if (command.equals("End")){
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.\n", dish, pots);
            System.out.printf("Leftover detergent %d ml.", soap);
        }
        else {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(soap - dishesSoap));
        }
    }
}


//if (price > 100){
  //      cardPayments += price;
    //    }



