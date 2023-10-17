import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            double number = Double.parseDouble(scanner.nextLine());
            numbers.add(number);
        }

        Collections.sort(numbers);
        Collections.reverse(numbers);

        for (Double digit: numbers){
            System.out.printf("%.0f%n", digit);
        }
    }
}
