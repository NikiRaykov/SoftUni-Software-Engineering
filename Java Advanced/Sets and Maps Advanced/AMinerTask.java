import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, Integer> data = new LinkedHashMap<>();

        while (!input.equals("stop")){
            String resource = input;
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!data.containsKey(resource)){
                data.put(resource, quantity);
            }else {
                int oldQuantity = data.get(resource);
                data.put(resource, oldQuantity + quantity);
            }

            input = scanner.nextLine();
        }

        data.forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));
    }
}
