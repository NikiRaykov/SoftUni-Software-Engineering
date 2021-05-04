import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // list input
        String line = scanner.nextLine();
        String[] numbersAsString = line.split(" ");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numbersAsString.length; i++) {
            int number = Integer.parseInt(numbersAsString[i]);
            numbers.add(number);
        }

        for (int i = 0; i < numbers.size() - 1; i++) {
            numbers.set(i, numbers.get(i) + numbers.get(numbers.size() - 1));
            numbers.remove(numbers.size() - 1);
        }

        for (int n: numbers){
            System.out.print(n + " ");
        }
    }
}
