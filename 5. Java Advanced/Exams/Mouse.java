import java.util.Scanner;

public class Mouse {
    static int cheese = 0;
    static boolean isInside = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = readCharMatrix(size, scanner);

        int[] position = findStartingPoint(matrix);


        String command = scanner.nextLine();

        while (!command.equals("end") && isInside){
            if (command.equals("up")){
                isInside = movePosition(matrix, position, -1, 0);
            }else if (command.equals("down")){
                isInside = movePosition(matrix, position, +1, 0);
            }else if (command.equals("left")){
                isInside = movePosition(matrix, position, 0, -1);
            }else if (command.equals("right")){
                isInside = movePosition(matrix, position, 0, +1);
            }

            if (!isInside){
                System.out.println("Where is the mouse?");
                break;
            }

            command = scanner.nextLine();
        }

        if (cheese < 5){
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
        }else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);
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

    private static boolean movePosition(char[][] matrix, int[] position, int rowMod, int colMod) {
        int startRow = position[0];
        int startCol = position[1];

        int newRow = startRow + rowMod;
        int newCol = startCol + colMod;

        if (isOutOfBounds(newRow, newCol, matrix)){
            matrix[startRow][startCol] = '-';
            return false;
        }

        if (matrix[newRow][newCol] == 'B'){
            matrix[newRow][newCol] = 'M';
            position[0] = newRow;
            position[1] = newCol;
            isInside = movePosition(matrix, position, rowMod, colMod);
            newRow = newRow + rowMod;
            newCol = newCol + colMod;

            if (matrix[newRow][newCol] == 'c'){
                cheese++;
            }
            if (isOutOfBounds(newRow, newCol, matrix)){
                matrix[startRow][startCol] = '-';
                return false;
            }
        }else if (matrix[newRow][newCol] == 'c') {
            cheese++;
        }

        matrix[startRow][startCol] = '-';
        matrix[newRow][newCol] = 'M';
        position[0] = newRow;
        position[1] = newCol;

        return true;
    }

    private static boolean isOutOfBounds(int r, int c, char[][] matrix) {
        return r >= matrix.length || r < 0 || c >= matrix[r].length || c < 0;
    }


    private static int[] findStartingPoint(char[][] matrix) {
        int[] position = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'M'){
                    position[0] = row;
                    position[1] = col;
                    break;
                }
            }
        }
        return position;
    }

    private static char[][] readCharMatrix(int size, Scanner scanner){
        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
        }
        return matrix;
    }
}
