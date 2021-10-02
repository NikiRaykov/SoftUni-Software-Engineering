import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int border = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");
        Predicate<String> checkCondition = n -> n.length() <= border;

        for (String name: names) {
            if (checkCondition.test(name)){
                System.out.println(name);
            }
        }
    }
}
