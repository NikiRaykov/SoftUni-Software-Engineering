import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfRounds = Integer.parseInt(scanner.nextLine());

        Map<String, String> parking = new LinkedHashMap<>();

        for (int i = 0; i < numberOfRounds; i++) {
            String input = scanner.nextLine();

            String command = input.split(" ")[0];

            if (command.equals("register")){
                String name = input.split(" ")[1];
                String plateNumber = input.split(" ")[2];
                if (!parking.containsKey(name)){
                    parking.put(name, plateNumber);
                    System.out.printf("%s registered %s successfully%n", name, parking.get(name));
                }else {
                    System.out.printf("ERROR: already registered with plate number %s%n", parking.get(name));
                }
            }else if (command.equals("unregister")){
                String name = input.split(" ")[1];
                if (!parking.containsKey(name)){
                    System.out.printf("ERROR: user %s not found%n", name);
                }else {
                    System.out.printf("%s unregistered successfully%n", name);
                    parking.remove(name);
                }
            }
        }
        parking.forEach((key, value) -> System.out.printf("%s => %s%n", key, value));
    }
}
