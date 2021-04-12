import java.util.Scanner;

public class OnTime {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine()); // 0 to 23
        int examMin = Integer.parseInt(scanner.nextLine()); // 0 to 59
        int arrivalHour = Integer.parseInt(scanner.nextLine()); // 0 to 23
        int arrivalMin = Integer.parseInt(scanner.nextLine()); // 0 to 59

        if (examHour == arrivalHour){
            if (examMin == arrivalMin){
                System.out.print("On time");
            }
        }

        if (examHour == arrivalHour){
            if (arrivalMin > examMin){
                System.out.print("Late\n");
                System.out.printf("%d minutes after the start", arrivalMin - examMin);
            }
        }

        if (examHour > arrivalHour){
            if (arrivalMin - examMin == 30){
                System.out.println("On time");
                System.out.printf("%d minutes before the start", arrivalMin);
            }
        }

        if (examHour > arrivalHour){
            System.out.print("Early\n");
            System.out.printf("%d hours before the start", examHour - arrivalHour);
        }

        if (examHour < arrivalHour){
            if (examMin < arrivalMin){
                System.out.print("Late\n");
                System.out.printf("%d : %d hours after the start", examHour - arrivalHour, arrivalMin);
            }else if (examMin > arrivalMin){
                System.out.print("Late\n");
                System.out.printf("%d minutes after the start", examMin - arrivalMin);
            }
        }

        if (examHour > arrivalHour){
            if (arrivalMin > examMin){
                System.out.println("On time");
                System.out.printf("%d minutes before the start", 60 - arrivalMin);
            }
        }

        if (examHour > arrivalHour){
            if (examMin > arrivalMin){
                System.out.println("Early");
                System.out.printf("%d : %d hours before the start", examHour - arrivalHour, examMin - arrivalMin);
            }
        }
    }
}
