import java.util.Scanner;

public class MovieDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int filmingTime = Integer.parseInt(scanner.nextLine());
        int scenes = Integer.parseInt(scanner.nextLine());
        int sceneDuration = Integer.parseInt(scanner.nextLine());

        double preparationOfTheField = filmingTime * (15.0f/100.0f);
        double timeForShootingTheScenes = scenes * sceneDuration;
        double neededTime = preparationOfTheField + timeForShootingTheScenes;

        if (neededTime > filmingTime){
            System.out.printf("Time is up! To complete the movie you need %.0f minutes.", neededTime - filmingTime);
        }else {
            System.out.printf("You managed to finish the movie on time! You have %.0f minutes left!", filmingTime - neededTime);
        }
    }
}