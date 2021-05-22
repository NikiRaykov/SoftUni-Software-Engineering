import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String commands = scanner.nextLine();

        while (!commands.equals("end")){
            String[] tokens = commands.split(" ");

            switch (tokens[0]){
                case "swap":
                    Collections.swap(numbers, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "multiply":
                    int result;
                    int firstEl = numbers.get(Integer.parseInt(tokens[1]));
                    int secondEl = numbers.get(Integer.parseInt(tokens[2]));
                    result = firstEl * secondEl;
                    numbers.set(numbers.indexOf(firstEl), result);
                    break;
                case "decrease":
                    for (int i = 0; i < numbers.size(); i++) {
                        numbers.set(i, numbers.get(i) - 1);
                    }
                    break;
            }

            commands = scanner.nextLine();
        }
        boolean isFirst = true;
        for (int n : numbers) {
            if (isFirst) {
                System.out.print(n);
                isFirst = false;
            } else {
                System.out.print(", "+n);
            }
        }
    }
}
