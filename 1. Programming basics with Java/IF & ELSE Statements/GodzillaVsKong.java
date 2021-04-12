import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int extras = Integer.parseInt(scanner.nextLine()); // how many extras we have
        double clothingPrice = Double.parseDouble(scanner.nextLine());

        double discount = 0.0;

        double decor = budget * (10.0f/100.f);
        double price = extras * clothingPrice; // price for the clothing

        if (extras > 150){
            discount = price * (10.0f/100.0f);
            price -= discount;
        }

        double totalPrice = decor + price;

        if (totalPrice > budget){
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.02f leva more.", totalPrice - budget);
        }else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.02f leva left.", budget- totalPrice);
        }

    }
}



