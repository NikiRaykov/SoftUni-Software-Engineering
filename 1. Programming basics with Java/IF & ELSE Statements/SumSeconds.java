import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int first = Integer.parseInt(scanner.nextLine());
    int second = Integer.parseInt(scanner.nextLine());
    int third = Integer.parseInt(scanner.nextLine());

    int totalTimeSec = first + second + third;
    int min = totalTimeSec / 60;
    int sec = totalTimeSec % 60;

    if (sec < 10) {
        System.out.printf("%d:0%d", min, sec);
    }else {
        System.out.printf("%d:%d", min, sec);
    }
    }
}
