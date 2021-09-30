import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Consumer<int[]> printMin = arr -> System.out.println(Arrays.stream(arr).min().orElse(0));
        printMin.accept(numbers);
    }
}
