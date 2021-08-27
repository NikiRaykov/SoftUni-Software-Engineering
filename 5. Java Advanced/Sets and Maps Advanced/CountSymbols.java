import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        TreeMap<Character, Integer> symbolsInfo = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (!symbolsInfo.containsKey(ch)){
                symbolsInfo.put(ch, 1);
            }else {
                symbolsInfo.put(ch, symbolsInfo.get(ch) + 1);
            }
        }

        symbolsInfo.forEach((key, value) -> {
            System.out.printf("%s: %d time/s%n", key, value);
        });
    }
}
