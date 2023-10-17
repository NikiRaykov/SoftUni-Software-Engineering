import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");
        int[] numbers = new int[line.length];

        for (int i = 0; i < line.length; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }


        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];
            boolean isTopInt = true;
            for (int j = i + 1; j < numbers.length; j++) {

                if (currentNumber <= numbers[j]){
                   isTopInt = false;
                }
            }
            if (isTopInt){
                System.out.print(currentNumber + " ");
            }
        }
    }
}
