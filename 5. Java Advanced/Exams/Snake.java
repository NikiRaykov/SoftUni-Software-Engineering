import java.util.Arrays;
import java.util.Scanner;

public class Snake {

    static int snakeRow = 0;
    static int snakeCol = 0;
    static int food = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();

            if (line.contains("S")){
                snakeRow = row;
                snakeCol = line.indexOf("S");
            }
        }

        boolean isInside = true;

        while (food < 10 && isInside){
            String command = scanner.nextLine();

            if (command.equals("up")){
                isInside = moveSnake(matrix, snakeRow - 1, snakeCol);
            }else if (command.equals("down")){
                isInside = moveSnake(matrix, snakeRow + 1, snakeCol);
            }else if (command.equals("left")){
                isInside = moveSnake(matrix, snakeRow, snakeCol - 1);
            }else if (command.equals("right")){
                isInside = moveSnake(matrix, snakeRow, snakeCol + 1);
            }
        }

        if (!isInside){
            System.out.println("Game over!");
        }else {
            System.out.println("You won! You fed the snake.");
        }

        System.out.println("Food eaten: " + food);
        printMatrix(matrix);
    }

    private static boolean moveSnake(char[][] matrix, int newRow, int newCol) {
        matrix[snakeRow][snakeCol] = '.';

        if (isOutOfBounds(newRow, newCol, matrix)){
            return false;
        }

        if (matrix[newRow][newCol] == '*'){
            food++;
        }else if (matrix[newRow][newCol] == 'B'){
            matrix[newRow][newCol] = '.';
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == 'B'){
                        newRow = row;
                        newCol = col;
                        break;
                    }
                }
                if (matrix[newRow][newCol] == 'B'){
                    break;
                }
            }
        }

        matrix[newRow][newCol] = 'S';
        snakeRow = newRow;
        snakeCol = newCol;
        return true;
    }

    private static boolean isOutOfBounds(int r, int c, char[][] matrix) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }
    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix).map(row -> Arrays.toString(row).replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "")).forEach(System.out::println);
    }

}
