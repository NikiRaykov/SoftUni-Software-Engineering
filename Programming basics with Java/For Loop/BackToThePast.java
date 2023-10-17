import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double inheritedMoney = Double.parseDouble(scanner.nextLine());
        int year = Integer.parseInt(scanner.nextLine());
        double moneyLeft = 0;
        int age = 17;

        for (int i = 1800; i <= year; i++) {

             if (i % 2 == 0){
                 inheritedMoney -= 12000;
             }
            else{
                age += 2;
                inheritedMoney -= 12000 + (age * 50);

            }

        }
        if (inheritedMoney >= 0) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", inheritedMoney);
        }
        else {
            System.out.printf("He will need %.2f dollars to survive.", Math.abs(inheritedMoney));
        }
    }
}
