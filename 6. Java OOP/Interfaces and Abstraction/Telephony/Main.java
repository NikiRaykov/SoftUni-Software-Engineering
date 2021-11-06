import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Smartphone phone = new Smartphone(Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList()),
                Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList()));


        System.out.println(phone.call());
        System.out.println(phone.browse());

    }
}
