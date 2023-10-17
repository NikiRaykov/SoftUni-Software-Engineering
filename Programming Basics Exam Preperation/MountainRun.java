import java.util.Scanner;

public class MountainRun {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double recordInSeconds = Double.parseDouble(scanner.nextLine());
        double meters = Double.parseDouble(scanner.nextLine());
        double metersPerSecond = Double.parseDouble(scanner.nextLine());

        double metersToClimb = 0;
        double delay = 0;
        double wholeTime = 0;

        metersToClimb = meters * metersPerSecond;
        delay = Math.floor(meters/50) * 30;
        wholeTime = metersToClimb + delay;


        if (wholeTime < recordInSeconds){
            System.out.printf("Yes! The new record is %.2f seconds.", wholeTime);
        }
        else {
            System.out.printf("No! He was %.2f seconds slower.", Math.abs(recordInSeconds - wholeTime));
        }
    }
}