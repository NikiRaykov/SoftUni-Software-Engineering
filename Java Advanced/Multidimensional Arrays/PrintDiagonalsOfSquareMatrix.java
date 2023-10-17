import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int n = Integer.parseInt(scanner.nextLine());

       int[][] matrix = new int[n][n];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(scanner);
        }

        printDiagonal(n, matrix);
    }

    private static void printDiagonal(int n, int[][] matrix) {
        int row = 0, col = 0;
        while (row < n && col < n) {
            System.out.print(matrix[row++][col++] + " ");
        }
        System.out.println();
        row = n - 1;
        col = 0;
        while (row >= 0 && col < n) {
            System.out.print(matrix[row--][col++] + " ");
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
