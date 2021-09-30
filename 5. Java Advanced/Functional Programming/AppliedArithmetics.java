import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();

        Consumer<int[]> printNumbers = array -> Arrays.stream(array).forEach(e -> System.out.print(e + " "));
        Function<int[], int[]> addOne = array -> Arrays.stream(array).map(el -> el += 1).toArray();
        Function<int[], int[]> multiply = array -> Arrays.stream(array).map(el -> el *= 2).toArray();
        Function<int[], int[]> subtract = array -> Arrays.stream(array).map(el -> el -= 1).toArray();

        while (!input.equals("end")){

            if (input.equals("add")){
                numbers = addOne.apply(numbers);
            }else if (input.equals("multiply")){
                numbers = multiply.apply(numbers);
            }else if (input.equals("print")){
                printNumbers.accept(numbers);
                System.out.println();
            }else if (input.equals("subtract")){
               numbers = subtract.apply(numbers);
            }

            input = scanner.nextLine();
        }
    }
}
