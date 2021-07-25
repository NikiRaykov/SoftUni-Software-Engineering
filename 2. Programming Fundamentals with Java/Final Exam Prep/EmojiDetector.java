import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regexForTreshHold = "\\d";
        String emojiRegex = "([*]{2}|[:]{2})[A-Z][a-z]{2,}\\1";

        Pattern patternForEmoji = Pattern.compile(emojiRegex);
        Pattern patternForTreshHold = Pattern.compile(regexForTreshHold);

        Matcher numberMatcher = patternForTreshHold.matcher(input);
        Matcher matcherForWords = patternForEmoji.matcher(input);

        List<Integer> numberList = new ArrayList<>();
        while (numberMatcher.find()){
            int number = Integer.parseInt(numberMatcher.group());
            numberList.add(number);
        }
            long coolness = numberList.stream().reduce(1, (a, b) -> a * b);
            System.out.println("Cool threshold: " + coolness);

        List<String> words = new ArrayList<>();
        while (matcherForWords.find()){
            words.add(matcherForWords.group());
        }

        System.out.println(words.size() + " emojis found in the text. The cool ones are:");

        for (int i = 0; i < words.size(); i++) {
            char[] chars = words.get(i).toCharArray();
            int sum = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != 58 && chars[j] != 42){
                    sum += chars[j];
                }
            }
            if (sum >= coolness){
                System.out.println(words.get(i));
            }
        }
    }
}
