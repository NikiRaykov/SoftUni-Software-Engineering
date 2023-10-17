import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<String, LinkedHashMap<String, Double>> shopsInfo = new TreeMap<>();

        while (!input.equals("Revision")){
            String[] info = input.split(", ");

            String shop = info[0];
            String product = info[1];
            double price = Double.parseDouble(info[2]);


            if (!shopsInfo.containsKey(shop)){
                shopsInfo.put(shop, new LinkedHashMap<>());
            }
            shopsInfo.get(shop).put(product, price);

            input = scanner.nextLine();
        }
        shopsInfo.forEach((key, value) -> {
            System.out.printf("%s->%n", key);
            value.forEach((key1, value1) ->
                    System.out.printf("Product: %s, Price: %.1f%n", key1, value1));
        });
    }
}
