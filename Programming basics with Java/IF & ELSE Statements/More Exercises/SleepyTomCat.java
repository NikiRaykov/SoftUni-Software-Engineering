import java.util.Scanner;

public class SleepyTomCat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int freeDays = Integer.parseInt(scanner.nextLine()); // броят почивни дни

        int workingDays = 365 - freeDays;
        int playWhenDayOff = freeDays * 127;
        int playWhenWork = workingDays * 63;
        int playTime = playWhenWork + playWhenDayOff;
        int timeLessOrMoreToPlay = Math.abs(playTime - 30000);
        int hours = timeLessOrMoreToPlay / 60;
        int min = timeLessOrMoreToPlay % 60;

        if (playTime < 30000){
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", hours, min);
        }else if (playTime > 30000) {
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", hours, min);
        }else {
            System.out.println();
        }


    }
}