import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

           String[] week = {"Monday", "Tuesday" , "Wednesday", "Thursday",
           "Friday", "Saturday", "Sunday"};

            int dayNumber = Integer.parseInt(scanner.nextLine());

            switch (dayNumber){
                case 1:
                    System.out.println(week[0]);
                    break;
                case 2:
                    System.out.println(week[1]);
                    break;
                case 3:
                    System.out.println(week[2]);
                    break;
                case 4:
                    System.out.println(week[3]);
                    break;
                case 5:
                    System.out.println(week[4]);
                    break;
                case 6:
                    System.out.println(week[5]);
                    break;
                case 7:
                    System.out.println(week[6]);
                    break;
                default:
                    System.out.println("Invalid day!");
                    break;
            }
        }
}
