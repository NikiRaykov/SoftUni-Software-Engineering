import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        if (numbers.length < 1){
            System.out.print(0);
            return;
        }
        // 1 2 3 3
        boolean areEqual = false;
        for (int i = 0; i < numbers.length; i++) {
            int leftSum = 0; int rightSum = 0;

            // left sum
                for (int j = i- 1; j >= 0; j--) {
                    leftSum += numbers[j];
            }

            // right sum
            for (int j = i + 1; j < numbers.length; j++) {
                rightSum += numbers[j];
            }

            if (leftSum == rightSum){
                areEqual = true;
                System.out.print(i);
                break;
            }
        }
        if (!areEqual){
            System.out.print("no");
        }
    }
}
