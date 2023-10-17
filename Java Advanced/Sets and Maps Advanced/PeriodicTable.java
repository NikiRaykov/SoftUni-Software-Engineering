import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfChemicals = Integer.parseInt(scanner.nextLine());

        Set<String> chemicals = new TreeSet<>();

        for (int i = 0; i < numberOfChemicals; i++) {
            String[] chemical = scanner.nextLine().split("\\s+");

            if (chemical.length > 0){
                Collections.addAll(chemicals, chemical);
            }
        }
        for (String s: chemicals){
            System.out.print(s + " ");
        }
    }
}
