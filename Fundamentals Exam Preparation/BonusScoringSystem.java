import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scanner.nextLine());
        int lecturesInTheCourse = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = 0; int attendances = 0; int maxAttendances = 0;
        for (int i = 0; i < studentsCount; i++) {
            double totalBonus = 0.0;
            attendances = Integer.parseInt(scanner.nextLine());

            totalBonus = ((double) attendances / lecturesInTheCourse) * (5 + additionalBonus);
            if (totalBonus > maxBonus){
                maxBonus = totalBonus;
                maxAttendances = attendances;
            }
        }
        System.out.printf("Max Bonus: %d.%n", Math.round(maxBonus));
        System.out.printf("The student has attended %d lectures.", maxAttendances);
    }
}
