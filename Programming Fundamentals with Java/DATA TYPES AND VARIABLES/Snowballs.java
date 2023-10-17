import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int snowballs = Integer.parseInt(scanner.nextLine());
        int snowballValue = 0; int highest = 0; int snowballSnow = 0; int snowballTime = 0; int snowballQuality = 0;
        int finalValue = 0; int finalSnow = 0; int finalTime = 0; int finalQuality = 0;

        for (int i = 1; i <= snowballs; i++) {
            snowballSnow = Integer.parseInt(scanner.nextLine());
            snowballTime = Integer.parseInt(scanner.nextLine());
            snowballQuality = Integer.parseInt(scanner.nextLine());

            snowballValue = (snowballSnow / snowballTime);
            snowballValue = (int) Math.pow(snowballValue, snowballQuality);

            if (snowballValue > highest){
                highest = snowballValue;
                finalValue = snowballValue;
                finalSnow = snowballSnow;
                finalTime = snowballTime;
                finalQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %d (%d)", finalSnow, finalTime, finalValue, finalQuality);
    }
}
