import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        long facSum = recursiveFactorial(n);
        System.out.println(facSum);
    }

    public static long recursiveFactorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * recursiveFactorial(n - 1);
    }
}
