import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double recordInSec = Double.parseDouble(scanner.nextLine()); // the world record in seconds
        double recordInMeters = Double.parseDouble(scanner.nextLine()); // the world record in meters
        double timeInSec = Double.parseDouble(scanner.nextLine()); // the time in seconds for one meter swam

        double timeNeeded = 0.0; double addedTime = 0.0; double totalTime = 0.0;

        timeNeeded = recordInMeters * timeInSec;
        addedTime = Math.floor((recordInMeters / 15)) * 12.5;
        totalTime = timeNeeded + addedTime;


        if (recordInSec < totalTime){
            System.out.printf("No, he failed! He was %.2f seconds slower.", totalTime - recordInSec);
        }else{
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totalTime);
        }

    }
}
