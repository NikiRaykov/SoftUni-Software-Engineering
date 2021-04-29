import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String seriesName = scanner.nextLine();
        int episodeDuration = Integer.parseInt(scanner.nextLine());
        int lunchBreakDuration = Integer.parseInt(scanner.nextLine());

        double lunchTime = lunchBreakDuration * (12.5f/100.0f);
        double chillTime = lunchBreakDuration * (25.0f/100.0f);
        double freeTimeLeft = lunchBreakDuration - lunchTime - chillTime;


        if (freeTimeLeft >= episodeDuration){
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", seriesName, Math.ceil(freeTimeLeft - episodeDuration));
        }else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", seriesName, Math.ceil(episodeDuration - freeTimeLeft));
        }
    }
}
