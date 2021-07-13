import java.util.*;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> output = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char key = input.charAt(i);

            if (key != 32){
                if (!output.containsKey(key)){
                    output.put(key, 1);
                }else {
                    int counter = output.get(input.charAt(i));
                    counter++;
                    output.put(key, counter);
                }
            }
        }
        output.forEach((key, value) -> System.out.printf("%c -> %d%n", key, value));
    }
}

