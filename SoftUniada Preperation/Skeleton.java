import java.util.*;

public class Skeleton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int controlMinutes = Integer.parseInt(scanner.nextLine());
        int controlSeconds = Integer.parseInt(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        int secondsForHundredMeters = Integer.parseInt(scanner.nextLine());

        double seconds = (controlMinutes * 60) + controlSeconds;
        double late = distance / 120;
        double timeRemoved = late * 2.5;
        double marinTime = (distance / 100) * secondsForHundredMeters - timeRemoved;

        if (marinTime <= seconds){
            System.out.println("Marin Bangiev won an Olympic quota!");
            System.out.printf("His time is %.3f.",marinTime);
        }else {
            System.out.printf("No, Marin failed! He was %.3f second slower.", marinTime-seconds);
        }
    }
}

