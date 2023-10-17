import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        int number = scanner.nextInt();

        searchInMatrix(matrix, number);
    }

    private static void searchInMatrix(int[][] matrix, int number) {
        boolean isFound = false;
        for (int row = 0; row < matrix.length; row++) {
            int[] currentArr = matrix[row];
            for (int col = 0; col < currentArr.length; col++) {
                if (currentArr[col] == number){
                    System.out.printf("%d %d%n", row, col);
                    isFound = true;
                }
            }
        }
        if (!isFound){
            System.out.println("not found");
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
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
}
