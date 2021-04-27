import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chickenMenus = Integer.parseInt(scanner.nextLine());
        int fishMenus = Integer.parseInt(scanner.nextLine());
        int vegetarianMenus = Integer.parseInt(scanner.nextLine());

        double sum = 0; double desertPrice = 0; double deliveryPrice = 2.50;

        sum = (chickenMenus * 10.35) + (fishMenus * 12.40) + (vegetarianMenus * 8.15);
        desertPrice = sum * (20.0f/100.0f);
        sum += deliveryPrice + desertPrice;
        System.out.printf("Total: %.2f", sum);
    }
}
