import javax.sound.midi.Soundbank;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "^%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$$";

        Pattern pattern = Pattern.compile(regex);

        String name = ""; String product = ""; int count = 0; double price = 0.0; double totalPriceForTheDay = 0.0;
        while (!input.equals("end of shift")){
            Matcher matcher = pattern.matcher(input);
            double paid = 0.0;
            if (matcher.find()){
                 name = matcher.group("name");
                 product = matcher.group("product");
                 count = Integer.parseInt(matcher.group("count"));
                 price = Double.parseDouble(matcher.group("price"));
                 paid = count * price;
                System.out.printf("%s: %s - %.2f%n", name, product, paid);
            }

            totalPriceForTheDay += paid;
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", totalPriceForTheDay);
    }
}
