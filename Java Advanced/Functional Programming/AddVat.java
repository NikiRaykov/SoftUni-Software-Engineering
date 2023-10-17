import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;


public class AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Prices with VAT:");
        UnaryOperator<Double> pricesWithVat = p -> p * 1.20;

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .map(pricesWithVat)
                .forEach(vatPrice -> System.out.printf("%.2f%n", vatPrice));

    }
}
