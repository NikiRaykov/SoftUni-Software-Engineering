import java.util.Scanner;

public class Balls {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int ballsCount = Integer.parseInt(scanner.nextLine());
        int points = 0; int redPoints = 0; int orangePoints = 0; int yellowPoints = 0;
        int whitePoints = 0; int blackPoints = 0; int otherPoints = 0;

        for (int i = 1; i <= ballsCount; i++) {
            String colors = scanner.nextLine();

            if (colors.equals("red")){
                points += 5;
                redPoints++;
            }
            else if (colors.equals("orange")){
                points += 10;
                orangePoints++;
            }
            else if (colors.equals("yellow")){
                points += 15;
                yellowPoints++;
            }
            else if (colors.equals("white")){
                points += 20;
                whitePoints++;
            }
            else if (colors.equals("black")){
                points /= 2;
                blackPoints++;
            }
            else {
                otherPoints++;
            }
        }
        System.out.printf("Total points: %d%n", points);
        System.out.printf("Points from red balls: %d%n", redPoints);
        System.out.printf("Points from orange balls: %d%n", orangePoints);
        System.out.printf("Points from yellow balls: %d%n", yellowPoints);
        System.out.printf("Points from white balls: %d%n", whitePoints);
        System.out.printf("Other colors picked: %d%n", otherPoints);
        System.out.printf("Divides from black balls: %d", blackPoints);
    }
}
