import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([a-zA-Z0-9]+([._-]?)[a-zA-Z0-9]+)(?<separator>@)([a-zA-Z]+[-]?[a-z]+([.])[a-z]+([.])?[a-z]+)";
        String input = scanner.nextLine();

        Pattern patternForMail = Pattern.compile(regex);
        Matcher matcherForMail = patternForMail.matcher(input);

        while (matcherForMail.find()){
            System.out.println(matcherForMail.group());
        }
    }
}
