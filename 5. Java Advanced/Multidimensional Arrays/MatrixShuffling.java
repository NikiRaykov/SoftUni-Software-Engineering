import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = readMatrix(scanner);

        String input = scanner.nextLine();

        while (!input.equals("END")){
            String[] commands = input.split("\\s+");

            if (!commands[0].equals("swap") || commands.length != 5){
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            int row1 = Integer.parseInt(commands[1]);
            int col1 = Integer.parseInt(commands[2]);
            int row2 = Integer.parseInt(commands[3]);
            int col2 = Integer.parseInt(commands[4]);

            if (row1 > matrix.length || row2 > matrix.length){
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            if (col1 > matrix.length || col2 > matrix.length){
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            String temp = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = temp;
            printMatrix(matrix);

            input = scanner.nextLine();
        }

    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static String[][] readMatrix(Scanner scanner) {
        int[] rowsAndCols = readArray(scanner);

        String[][] matrix = new String[rowsAndCols[0]][rowsAndCols[1]];
        for (int i = 0; i < rowsAndCols[0]; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}
