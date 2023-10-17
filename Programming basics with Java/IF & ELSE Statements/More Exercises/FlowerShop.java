import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double magnoliasPrice = 0.0; // 3.25
        double hyacinthPrice = 0.0;  // 4.00
        double rosesPrice = 0.0; // 3.50
        double cactusPrice = 0.0;   // 8.00

        int magnoliasCount = Integer.parseInt(scanner.nextLine());
        int hyacinthCount = Integer.parseInt(scanner.nextLine());
        int rosesCount = Integer.parseInt(scanner.nextLine());
        int cactusCount = Integer.parseInt(scanner.nextLine());
        double giftPrice = Double.parseDouble(scanner.nextLine());

        double sum = 0;

        magnoliasPrice = 3.25 * magnoliasCount;
        hyacinthPrice = 4.00 * hyacinthCount;
        rosesPrice = 3.50 * rosesCount;
        cactusPrice = 8.00 * cactusCount;
        sum = magnoliasPrice + hyacinthPrice + rosesPrice + cactusPrice;
        sum -= sum * (5.0f/100.0f);

        if (sum >= giftPrice){
            System.out.printf("She is left with %.0f leva.", Math.floor(sum - giftPrice));
        }
        else{
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(giftPrice-sum));
        }
    }
}
