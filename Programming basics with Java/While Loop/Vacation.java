import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double vacationCost = Double.parseDouble(scanner.nextLine()); // money needed for the vacation
        double money = Double.parseDouble(scanner.nextLine()); // money that she has right now
        double moneySpent = 0; // money left after spending
        double moneySaved = 0; // saved money
        int daysCount = 0;
        int spendingCounter = 0;

        while (money < vacationCost && spendingCounter < 5){
            String spendOrSave = scanner.nextLine(); // she chooses if she will spend or save
            double spendingOrSaving = Double.parseDouble(scanner.nextLine()); // money that she will spend or save
            daysCount++;
            if (spendOrSave.equals("spend")){
                money = money - spendingOrSaving;
                spendingCounter++;
                if (money < 0){
                    money = 0;
                }
            }
            if (spendOrSave.equals("save")){
                money = money + spendingOrSaving;
                spendingCounter = 0;
            }
        }
            if (spendingCounter == 5){
                System.out.println("You can't save the money.");
                System.out.println(daysCount);
            }
            if (money >= vacationCost){
                System.out.printf("You saved the money for %d days.", daysCount);
            }
    }
}
