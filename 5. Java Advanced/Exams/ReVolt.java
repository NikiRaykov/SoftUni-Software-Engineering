import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        char[][] matrix = readCharMatrix(size, scanner);

        int[] position = findStartingPoint(matrix);

        boolean hasWon = false;

        while (numberOfCommands-- > 0 && !hasWon){
            String command = scanner.nextLine();

            if (command.equals("up")){
                hasWon = movePosition(matrix, position, -1, 0);
            }else if (command.equals("down")){
                hasWon = movePosition(matrix, position, +1, 0);
            }else if (command.equals("left")){
                hasWon = movePosition(matrix, position, 0, -1);
            }else if (command.equals("right")){
                hasWon = movePosition(matrix, position, 0, +1);
            }
        }

        if (hasWon){
            System.out.println("Player won!");
        }else {
            System.out.println("Player lost!");
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static boolean movePosition(char[][] matrix, int[] position, int rawMod, int colMod) {
        int startRow = position[0];
        int startCol = position[1];

        int newRow = ensureIndexIsInBounds(startRow + rawMod, matrix.length);
        int newCol = ensureIndexIsInBounds(startCol + colMod, matrix.length);

        boolean playerWon = false;

        if (matrix[newRow][newCol] == 'B'){
            newRow = ensureIndexIsInBounds(newRow + rawMod, matrix.length);
            newCol = ensureIndexIsInBounds(newCol + colMod, matrix.length);
            if (matrix[newRow][newCol] == 'F'){
                playerWon = true;
            }
        }else if (matrix[newRow][newCol] == 'T'){
            newRow = startRow;
            newCol = startCol;
        }else if (matrix[newRow][newCol] == 'F'){
            playerWon = true;
        }

        matrix[startRow][startCol] = '-';
        matrix[newRow][newCol] = 'f';
        position[0] = newRow;
        position[1] = newCol;
        return playerWon;
    }

    private static int ensureIndexIsInBounds(int index, int bounds) {
        if (index < 0){
            index = bounds - 1;
        }else if (index >= bounds){
            index = 0;
        }

        return index;
    }

    private static int[] findStartingPoint(char[][] matrix) {
        int[] position = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'f'){
                    position[0] = row;
                    position[1] = col;
                }
            }
        }
        return position;
    }

    private static char[][] readCharMatrix(int size, Scanner scanner){
        char[][] matrix = new char[size][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
        return matrix;
    }
}
