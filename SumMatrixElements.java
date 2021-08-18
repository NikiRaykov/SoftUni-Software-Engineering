import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        System.out.println(getSum(matrix));
    }

    private static int getSum(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            int[] currentArr = matrix[row];
            for (int col = 0; col < currentArr.length; col++) {
                sum += currentArr[col];
            }
        }
        return sum;
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] rowsAndCols = readArray(scanner);

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        System.out.println(rows);
        System.out.println(cols);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
                matrix[row] = readArray(scanner);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
