import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resource = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> miner = new LinkedHashMap<>();

        while (!resource.equals("stop")){

            if (miner.containsKey(resource)){
                miner.put(resource, miner.get(resource) + quantity);
            }else {
                miner.put(resource, quantity);
            }

            resource = scanner.nextLine();

            if (resource.equals("stop")){
                break;
            }
            quantity = Integer.parseInt(scanner.nextLine());
        }

        miner.forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));
    }
}
