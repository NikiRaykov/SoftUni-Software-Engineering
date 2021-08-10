import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "([#\\|])(?<food>[a-zA-z\\s]+)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d+)\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> output = new ArrayList<>();

        int totalCalories = 0;

        while (matcher.find()){
            output.add(String.format("Item: %s, Best before: %s, Nutrition: %d", matcher.group("food"),
                    matcher.group("date"), Integer.parseInt(matcher.group("calories"))));

            totalCalories += Integer.parseInt(matcher.group("calories"));
        }
        System.out.printf("You have food to last you for: %d days!%n", totalCalories / 2000);

        for (String s : output) {
            System.out.println(s);
        }
    }
}
