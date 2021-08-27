import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countries = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> dataOfContinents = new LinkedHashMap<>();

        for (int i = 0; i < countries; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String continent = data[0]; String country = data[1];  String city = data[2];

            dataOfContinents.putIfAbsent(continent, new LinkedHashMap<>());
            dataOfContinents.get(continent).putIfAbsent(country, new ArrayList<>());
            dataOfContinents.get(continent).get(country).add(city);
        }

        dataOfContinents.forEach((key, value) -> {
            System.out.printf("%s:%n", key);
            value.forEach((k, v) -> System.out.printf("  %s -> %s%n", k, String.join(", ", v)));
        });
    }
}
