import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryFirstSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());

        System.out.println(Integer.toBinaryString(decimal));
    }
}
