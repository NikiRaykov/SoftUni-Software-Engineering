import java.util.*;

public class Odd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Map<String, Integer> words = new LinkedHashMap<>();

        for (String value : input) {
            String word = value.toLowerCase();

            if (!words.containsKey(word)) {
                words.put(word, 1);
            } else {
                int counter = words.get(word);
                counter++;
                words.put(word, counter);
            }
        }
        List<String> odds = new ArrayList<>();

        for (Map.Entry<String, Integer> entry: words.entrySet()){
            if (entry.getValue() % 2 == 1){
                odds.add(entry.getKey());
            }
        }

        boolean isFirst = true;
        for (String s : odds) {
            if (isFirst) {
                System.out.print(s);        // no comma
                isFirst = false;
            } else {
                System.out.print(", "+s);   // comma
            }
        }
    }
}
