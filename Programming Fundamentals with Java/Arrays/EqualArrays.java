import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] line1 = scanner.nextLine().split(" ");
        String[] line2 = scanner.nextLine().split(" ");

        int[] numbers1 = new int[line1.length];
        int[] numbers2 = new int[line2.length];
        int sum = 0;
        boolean areEqual = Arrays.equals(numbers1, numbers2);

        for (int i = 0; i < numbers1.length; i++) {
            numbers1[i] = Integer.parseInt(line1[i]);
        }
        for (int i = 0; i < numbers2.length; i++) {
            numbers2[i] = Integer.parseInt(line2[i]);
        }

        if (areEqual) {
            for (int j : numbers1) {
                sum += j;
            }
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            for (int i = 0; i < numbers1.length; i++) {
                sum += numbers1[i];
                if (numbers1[i] != numbers2[i]) {
                    System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                    break;
                }
            }
        }
    }
}
