import java.util.Scanner;

public class TournamentOfChristmas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double moneyRaised = 0; double moneyLost = 0; int gamesWon = 0; int gamesLost = 0; int daysWon = 0; double totalMoney = 0.0;
        int daysLost = 0;

        for (int i = 1; i <= days; i++) {
            if (i >= 1){
                moneyRaised = 0; gamesLost = 0; gamesWon = 0;
            }
            String command = scanner.nextLine();
            while (!command.equals("Finish")) {
                String result = scanner.nextLine();

                if (result.equals("win")) {
                    moneyRaised += 20;
                    gamesWon++;
                } else {
                    moneyLost += 0;
                    gamesLost++;
                }

                command = scanner.nextLine();
            }

            if (gamesWon > gamesLost) {
                moneyRaised += (moneyRaised / 100) * 10;
                totalMoney += moneyRaised;
                daysWon++;
            } else {
                daysLost++;
                totalMoney += moneyRaised;
            }
        }
        if (daysWon > daysLost){
            totalMoney += (totalMoney / 100) * 20;
            System.out.printf("You won the tournament! Total raised money: %.2f", totalMoney);
        }else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", totalMoney);
        }
    }
}