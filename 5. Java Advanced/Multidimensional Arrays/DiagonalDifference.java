import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(scanner);
        }

        int sumPrimary = getSumPrimaryDiagonal(n, matrix);
        int sumSecondary = getSumOfSecondaryDiagonal(n, matrix);

        System.out.println(Math.abs(sumPrimary - sumSecondary));
    }

    private static int getSumOfSecondaryDiagonal(int n, int[][] matrix) {
        int sumOfSecondaryDiagonal = 0;
        int row = 0, col = 0;

        row = n - 1;
        while (row >= 0 && col < n){
            sumOfSecondaryDiagonal += matrix[row--][col++];
        }
        return  sumOfSecondaryDiagonal;
    }

    private static int getSumPrimaryDiagonal(int n, int[][] matrix) {
        // Primary diagonal
        int sumFirstDiagonal = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row == col){
                    sumFirstDiagonal += matrix[row][col];
                }
            }
        }
        return  sumFirstDiagonal;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
