import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = ">>(?<model>[A-Za-z]+)<<(?<price>[0-9]+.?[0-9]*)!(?<quantity>[0-9]+)";
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);

        double totalPrice = 0.0; double price = 0.0; int quantity = 0;
        List<String> furnitures = new ArrayList<>();

        while (!input.contains("Purchase")){
            Matcher findFurniture = pattern.matcher(input);
            if (findFurniture.find()){
                furnitures.add(findFurniture.group(1));
                 price = Double.parseDouble(findFurniture.group(2));
                quantity = Integer.parseInt(findFurniture.group(3));
                totalPrice += price * quantity;
            }

             input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String word: furnitures) {
            System.out.println(word);
        }
        System.out.printf("Total money spend: %.2f", totalPrice);
    }
}
