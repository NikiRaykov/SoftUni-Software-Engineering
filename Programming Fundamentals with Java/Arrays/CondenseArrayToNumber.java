import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");
        int[] numbers = new int[line.length];
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        int[] condensed = new int[numbers.length - 1];
    }
}
