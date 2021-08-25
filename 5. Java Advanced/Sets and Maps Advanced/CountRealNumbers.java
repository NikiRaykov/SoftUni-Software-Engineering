import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        LinkedHashMap<Double, Integer> realNumbers = new LinkedHashMap<>();

        for (double number : input) {
            if (!realNumbers.containsKey(number)) {
                realNumbers.put(number, 1);
            } else {
                realNumbers.put(number, realNumbers.get(number) + 1);
            }
        }
        realNumbers.forEach((key,value)-> System.out.printf("%.1f -> %d%n",key,value));
        }
    }

