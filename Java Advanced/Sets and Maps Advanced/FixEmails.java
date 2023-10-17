import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, String> emailsData = new LinkedHashMap<>();

        while (!input.equals("stop")){
            String name = input;
            String email = scanner.nextLine();

            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")){
                if (!emailsData.containsKey(email)){
                    emailsData.put(name, email);
                }
            }
            input = scanner.nextLine();
            }
        emailsData.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));
        }
    }

