import javax.xml.stream.events.Characters;
import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s");

        for (String s: input) {
            boolean isValid = true;
            if (s.length() < 3 || s.length() > 16){
                isValid = false;
                    }else {
                for (int i = 0; i < s.length(); i++) {
                    if (!Character.isLetterOrDigit(s.charAt(i)) && s.charAt(i) != '_' && s.charAt(i) != '-') {
                        isValid = false;
                    }
                }
                if (isValid){
                    System.out.println(s);
                }
                    }
                }
            }
        }

