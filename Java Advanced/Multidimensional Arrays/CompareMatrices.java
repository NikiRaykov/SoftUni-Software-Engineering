import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);


        String output = areNotEqual(firstMatrix, secondMatrix) ? "equal" : "not equal";
        System.out.println(output);
        // printMatrix(matrix);
    }

    private static boolean areNotEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix == null) {
            return (secondMatrix == null);
        }
        if (secondMatrix == null) {
            return false;
        }
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int i = 0; i < firstMatrix.length; i++) {
            if (!Arrays.equals(firstMatrix[i], secondMatrix[i])) {
                return false;
            }
        }
        return true;
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] rowsAndCols = readArray(scanner);

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = readArray(scanner);
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = matrix[row];
            for (int col = 0; col < arr.length; col++) {
                System.out.print(arr[col] + " ");
            }
            System.out.println();
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

