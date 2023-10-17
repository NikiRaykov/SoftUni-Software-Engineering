import java.util.Scanner;

public class ToyShop {

    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    double tripPrice = Double.parseDouble(scanner.nextLine());
    int puzzlesCount = Integer.parseInt(scanner.nextLine());
    int dollsCount = Integer.parseInt(scanner.nextLine());
    int teddyBearsCount = Integer.parseInt(scanner.nextLine());
    int minionsCount = Integer.parseInt(scanner.nextLine());
    int trucksCount = Integer.parseInt(scanner.nextLine());

    double quantityToys = puzzlesCount + dollsCount + teddyBearsCount + minionsCount + trucksCount; // 135
    double wholeSum = (puzzlesCount * 2.60) + (dollsCount * 3) + (teddyBearsCount * 4.10) + (minionsCount * 8.20) + (trucksCount *2); // 680

   if (quantityToys >= 50) {
       wholeSum = wholeSum - (wholeSum * 0.25);
    }
    wholeSum = wholeSum - (wholeSum * 0.10);

   if (wholeSum >= tripPrice){
       System.out.printf("Yes! %.2f lv left.", wholeSum - tripPrice);
   }else {
       System.out.printf("Not enough money! %.2f lv needed.", tripPrice - wholeSum);
   }
    }
    }



