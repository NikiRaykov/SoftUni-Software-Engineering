import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstEmployee = Integer.parseInt(scanner.nextLine()); // per hours
        int secondEmployee = Integer.parseInt(scanner.nextLine()); // per hours
        int thirdEmployee = Integer.parseInt(scanner.nextLine()); // per hours
        int peopleCount = Integer.parseInt(scanner.nextLine()); // clients

        int peopleAnsweredForAnHour = firstEmployee + secondEmployee + thirdEmployee;
        int hours = 0;

        while (peopleCount > 0){
            hours++;
            if (hours % 4 != 0) {
                peopleCount -= peopleAnsweredForAnHour;
            }
        }
        System.out.printf("Time needed: %dh.", hours);
    }
}
