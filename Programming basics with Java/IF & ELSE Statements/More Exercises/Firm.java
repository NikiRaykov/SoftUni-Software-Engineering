import java.util.Scanner;

public class Firm {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine()); // hours needed for the project
        int days = Integer.parseInt(scanner.nextLine());    // the firm has 7 days
        int overtimeWorkers = Integer.parseInt(scanner.nextLine());

        int trainingHours = 0;
        int wholeHours = 0;

        trainingHours = (int) ((days * 0.90) * 8);
        overtimeWorkers = overtimeWorkers * (2 * days);
        wholeHours = (int) Math.floor(trainingHours + overtimeWorkers); // 92 > 90

        if (wholeHours > hours){
            System.out.printf("Yes!%d hours left.", wholeHours - hours);
        }
        else {
            System.out.printf("Not enough time!%d hours needed.", hours - wholeHours);
        }
    }
}

