import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashMap<String, String> phoneBook = new HashMap<>();

        while (!input.equals("stop")){
            if (input.equals("search")){
                input = scanner.nextLine();
                while (!input.equals("stop")){
                    if (phoneBook.containsKey(input)){
                            System.out.printf("%s -> %s%n", input, phoneBook.get(input));
                    }else {
                        System.out.printf("Contact %s does not exist.%n", input);
                    }
                    input = scanner.nextLine();
                }
            }

            if (input.equals("stop")){
                return;
            }

            String[] data = input.split("-");

            String name = data[0];
            String phoneNumber = data[1];

            phoneBook.put(phoneBook.getOrDefault(name, name), phoneNumber);

            input = scanner.nextLine();
        }
    }
}
