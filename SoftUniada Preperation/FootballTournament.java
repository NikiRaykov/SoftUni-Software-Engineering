import java.util.Scanner;

public class FootballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String footballTeam = scanner.nextLine();
        int playedGames = Integer.parseInt(scanner.nextLine());

        if (playedGames == 0){
            System.out.printf("%s hasn't played any games during this season.", footballTeam);
            return;
        }

        int points = 0; double wins = 0; double draws = 0; double loses = 0;

        for (int i = 0; i < playedGames; i++) {
            String result = scanner.nextLine();

            if (result.equals("W")){
                points += 3;
                wins++;
            }else if (result.equals("D")){
                points += 1;
                draws++;
            }else if (result.equals("L")){
                points += 0;
                loses++;
            }
        }
        System.out.printf("%s has won %d points during this season.%n", footballTeam, points);
        System.out.println("Total stats: ");
        System.out.printf("## W: %.0f%n", wins);
        System.out.printf("## D: %.0f%n", draws);
        System.out.printf("## L: %.0f%n", loses);
        System.out.printf("Win rate: %.2f%%", (wins / playedGames) * 100);
    }
}
