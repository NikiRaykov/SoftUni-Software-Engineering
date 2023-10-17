import java.util.Scanner;

public class TownInfo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        double population = Double.parseDouble(scanner.nextLine());
        double area = Double.parseDouble(scanner.nextLine());

        System.out.printf("Town %s has population of %.0f and area %.0f square km.", town, population, area);
    }
}
