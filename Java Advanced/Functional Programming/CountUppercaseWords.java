import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("\\s+");

        Predicate<String> isCapital = word -> Character.isUpperCase(word.charAt(0));

        ArrayList<String> result = new ArrayList<>();

        for (String s : text) {
            if (isCapital.test(s)) {
                result.add(s);
            }
        }

        Consumer<ArrayList<String>> count = word -> System.out.println(result.size());
        count.accept(result);

        Consumer<ArrayList<String>> printResult = list -> list.forEach(System.out::println);
        printResult.accept(result);
    }
}
