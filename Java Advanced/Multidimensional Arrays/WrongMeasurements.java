import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        int wrongValue = findWrongValue(matrix, scanner);

        List<int []> updated = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue){
                    updated.add(new int[] {row, col, getClosesItemsSum(row, col, matrix, wrongValue)});
                }
            }
        }

        for (int[] value: updated){
            matrix[value[0]][value[1]] = value[2];
        }


        printMatrix(matrix);

    }

    private static int getClosesItemsSum(int row, int col, int[][] matrix, int wrongValue) {
        int sum = 0;

        if (row - 1 >= 0 && matrix[row - 1][col] != wrongValue){
           sum += matrix[row -1][col]; // UP
        };

        if (row + 1 < matrix.length && matrix[row + 1][col] != wrongValue){
          sum += matrix[row + 1][col]; // Down
        };

        if (col - 1 >= 0 && matrix[row][col - 1] != wrongValue){
         sum += matrix[row][col - 1]; // Left
        };

        if (col + 1 < matrix[row].length && matrix[row][col + 1] != wrongValue){
           sum += matrix[row][col + 1]; // Right
        };

        return sum;
    }


    public static int[] readArray(Scanner scanner){
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int[][] readMatrix(Scanner scanner){
        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(scanner);
        }
        return matrix;
    }

    public static int findWrongValue(int[][] matrix, Scanner scanner){
        int[] wrongValueCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = wrongValueCoordinates[0];
        int col = wrongValueCoordinates[1];

       return matrix[row][col];
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cols : row) {
                System.out.print(cols + " ");
            }
            System.out.println();
        }
    }

}
