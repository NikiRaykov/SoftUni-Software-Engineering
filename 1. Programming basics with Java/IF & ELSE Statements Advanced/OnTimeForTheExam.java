import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMin = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMin= Integer.parseInt(scanner.nextLine());

        double lateHour = 0;
        double lateMin = 0;

        if (arrivalHour > examHour && arrivalMin > examMin){
            System.out.println("Late\n");
            lateHour = arrivalHour - examHour;
            lateMin = arrivalMin - examMin;

        }
        else if (arrivalHour == examHour && arrivalMin == examMin){
            System.out.println("On time");
        }
        else if (arrivalHour < examHour && arrivalMin < examMin){
            System.out.println("Early\n");
            lateHour = examHour - arrivalHour;
            lateMin = examMin - arrivalMin;
        }
        else if (arrivalHour == examHour && arrivalMin < examMin){
            System.out.println("Late");
        }

    }
}
