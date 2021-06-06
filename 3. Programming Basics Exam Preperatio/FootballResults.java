import java.util.*;

public class FootballResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstGameResult = scanner.nextLine();
        String secondGameResult = scanner.nextLine();
        String thirdGameResult = scanner.nextLine();

        int firstGame = firstGameResult.charAt(0);
        int firstGame1 = firstGameResult.charAt(2);

        int wins = 0; int draws = 0; int loses = 0;

        if (firstGame > firstGame1){
            wins++;
        }else if (firstGame == firstGame1){
            draws++;
        }else {
            loses++;
        }

        int secondGame = secondGameResult.charAt(0);
        int secondGame1 = secondGameResult.charAt(2);

        if (secondGame > secondGame1){
            wins++;
        }else if (secondGame == secondGame1){
            draws++;
        }else {
            loses++;
        }

        int thirdGame = thirdGameResult.charAt(0);
        int thirdGame1 = thirdGameResult.charAt(2);

        if (thirdGame > thirdGame1){
            wins++;
        }else if (thirdGame == thirdGame1){
            draws++;
        }else {
            loses++;
        }

        System.out.println("Team won " +  wins + " games.");
        System.out.println("Team lost " +  loses + " games.");
        System.out.println("Drawn games: " +  draws);


    }
}

