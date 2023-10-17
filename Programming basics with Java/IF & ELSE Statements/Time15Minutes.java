import java.util.Scanner;

public class Time15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int min = Integer.parseInt(scanner.nextLine());

        int totalTimeInMin = hour * 60 + min + 15;

        hour = totalTimeInMin / 60;
        min = totalTimeInMin % 60;

        if ( hour > 23){
            hour = 0;
        }
        System.out.printf("%d:%02d", hour, min);
    }
}
