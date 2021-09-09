import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrix(scanner, rows, cols);
        char[][] secondMatrix = readMatrix(scanner, rows, cols);

        char[][] result = matricesIntersection(firstMatrix, secondMatrix);
        printMatrix(result);
    }

    private static char[][] matricesIntersection(char[][] firstMatrix, char[][] secondMatrix){
        char[][] thirdMatrix = new char[firstMatrix.length][];

        for (int row = 0; row < firstMatrix.length; row++) {
            thirdMatrix[row] = new char[firstMatrix[row].length];
            for (int col = 0; col < firstMatrix[row].length; col++) {
                thirdMatrix[row][col] = firstMatrix[row][col] == secondMatrix[row][col] ?
                    firstMatrix[row][col]: '*';
            }
        }

        return thirdMatrix;
    }

    private static char[][] readMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int col = 0; col < tokens.length; col++) {
                matrix[row][col] = tokens[col].charAt(0);
            }
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char cols : row) {
                System.out.print(cols + " ");
            }
            System.out.println();
        }
    }
}
