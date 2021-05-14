import java.util.*;

public class Darts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String playerName = scanner.nextLine();
        String shot = scanner.nextLine();

        int startPoints = 301; int goodShots = 0; int badShots = 0; boolean finish = false;

        while(!shot.equals("Retire")){
            int points = Integer.parseInt(scanner.nextLine());

            if (shot.equals("Single")){
                if (points > startPoints){
                    badShots++;
                    shot = scanner.nextLine();
                    continue;
                }else {
                    startPoints -= points;
                    goodShots++;
                }

            }else if (shot.equals("Double")){
                if (points * 2 > startPoints){
                    badShots++;
                    shot = scanner.nextLine();
                    continue;
                }else {
                    startPoints -= points * 2;
                    goodShots++;
                }

            }else if (shot.equals("Triple")){
                if (points * 3 > startPoints){
                    badShots++;
                    shot = scanner.nextLine();
                    continue;
                }else{
                    startPoints -= points * 3;
                    goodShots++;
                }

            }

            if (startPoints <= 0){
                finish = true;
                break;
            }

            shot = scanner.nextLine();
        }
        if (finish){
            System.out.printf("%s won the leg with %d shots.", playerName, goodShots);
        }else {
            System.out.printf("%s retired after %d unsuccessful shots.", playerName, badShots);
        }
    }
}

