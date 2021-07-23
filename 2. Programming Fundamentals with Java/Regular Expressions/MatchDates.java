import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\b(?<day>\\d{2})([\\/.-])(?<month>\\w{3})\\2(?<year>\\d{4})\\b";

        String datesString = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher dates = pattern.matcher(datesString);

        while (dates.find()) {
            System.out.printf("Day: %s, Month: %s, Year: %s%n",
                    dates.group("day"), dates.group("month"), dates.group("year"));
        }

    }
}
