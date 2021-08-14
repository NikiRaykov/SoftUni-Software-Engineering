import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinalExamSecondProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String regex = "(\\|)(?<name>[A-Z]{4,})\\1(\\:)(\\#)(?<title>[A-Za-z]+\\s[A-Za-z]+)\\4";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);


            if (matcher.find()){
                String boss = matcher.group("name");
                String title = matcher.group("title");
                System.out.printf("%s, The %s%n", boss, title);
                System.out.printf(">> Strength: %d%n", boss.length());
                System.out.printf(">> Armor: %d%n", title.length());
            }else {
                System.out.println("Access denied!");
            }
        }
    }
}
