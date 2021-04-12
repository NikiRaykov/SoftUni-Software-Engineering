import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int ageLilly = Integer.parseInt(scanner.nextLine()); // Lilly's age
        double washingMachinePrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());

        int toys = 0;
        int money = 0;
        int moneyToys = 0;
        int wholeMoney = 0;
        int sumMoney = 0;

        for (int i = 1; i <= ageLilly; i++) {

            if (i % 2 != 0){
                toys++;
            }
            else {
                money = money +10;
                sumMoney += money;
                sumMoney -= 1;
            }
        }
        moneyToys = toys * toyPrice;
        wholeMoney = moneyToys + sumMoney;

        if (wholeMoney >= washingMachinePrice){
            System.out.printf("Yes! %.2f", wholeMoney - washingMachinePrice);
        }
        else {
            System.out.printf("No! %.2f", washingMachinePrice - wholeMoney);
        }
    }
}
