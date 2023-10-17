import java.util.Scanner;

public class EasterParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int guests = Integer.parseInt(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());

        double wholeSum = 0.0; double sum = 0.0; double cakePrice = 0.0;

        if (guests >= 10 && guests <= 15){
            price -= price * (15.0f/100.0f);
        }else if (guests > 15 && guests <= 20){
            price -= price * (20.0f/100.0f);
        }else if (guests > 20){
            price -= price * (25.0f/100.0f);
        }

        cakePrice = budget * (10.0f/100.0f);
        wholeSum = (guests * price) + cakePrice;

        if (wholeSum < budget){
            System.out.printf("It is party time! %.2f leva left.", budget - wholeSum);
        }else{
            System.out.printf("No party! %.2f leva needed.", wholeSum - budget);
        }
    }
}