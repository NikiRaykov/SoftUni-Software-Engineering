import java.util.Scanner;
// Write a program, which sums the ASCII codes of n characters.
//Print the sum on the console.


public class SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 0; i < numberOfLines; i++) {
            char ch = scanner.nextLine().charAt(0);
            sum += (int) ch;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
