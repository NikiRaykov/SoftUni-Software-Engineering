import java.util.Scanner;

public class Selling {

    static int startRow = 0;
    static int startCol = 0;
    static  int money = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("S")){
                startRow = row;
                startCol = line.indexOf("S");
            }
        }

         boolean isInBakery = true;

        while (money < 50 && isInBakery){
            String command = scanner.nextLine();

            if (command.equals("up")){
                isInBakery = move(startRow - 1, startCol, matrix);
            }else if (command.equals("down")){
                isInBakery = move(startRow + 1, startCol, matrix);
            }else if (command.equals("left")){
                isInBakery = move(startRow, startCol - 1, matrix);
            }else if (command.equals("right")){
                isInBakery = move(startRow, startCol + 1, matrix);
            }
        }

            if (!isInBakery){
                System.out.println("Bad news, you are out of the bakery.");
            }else {
                System.out.println("Good news! You succeeded in collecting enough money!");
            }
            System.out.println("Money: " + money);

           printMatrix(matrix);
    }

    private static boolean move(int newRow, int newCol, char[][] matrix) {
        matrix[startRow][startCol] = '-';

        if (isOutOfBounds(newRow, newCol, matrix)){
            return false;
        }

        char symbol = matrix[newRow][newCol];



        if (Character.isDigit(symbol)){
            money += symbol - '0';
        } else if (symbol == 'O'){
            matrix[newRow][newCol] = '-';
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == 'O'){
                        newRow = row;
                        newCol = col;
                        break;
                    }
                }
                if (matrix[newRow][newCol] == 'O'){
                    break;
                }
            }
        }

        matrix[newRow][newCol] = 'S';

        startRow = newRow;
        startCol = newCol;

        return true;
    }

    private static boolean isOutOfBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0 || col >= matrix[row].length || col < 0;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][size];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
        return matrix;
    }


}
