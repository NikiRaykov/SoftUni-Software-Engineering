import java.util.Scanner;

public class Python {

    static int food = 0;
    static int pRow = 0;
    static int pCol = 0;
    static int pLength = 1;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n =  Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(", ");

        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            matrix[row] = line.toCharArray();

            if (line.contains("s")){
                pRow = row;
                pCol = line.indexOf("s");
            }

            for (char c : matrix[row]) {
                if (c == 'f'){
                    food++;
                }
            }
        }

        // Till here is done
        for (String command : commands) {
            if (command.equals("up")){
                movePython(pRow - 1, pCol, matrix);
            }else if (command.equals("down")){
                movePython(pRow + 1, pCol, matrix);
            }else if (command.equals("left")){
                movePython(pRow, pCol - 1, matrix);
            }else if (command.equals("right")){
                movePython(pRow, pCol + 1, matrix);
            }

            if (pLength == -1 || food == 0){
                break;
            }
        }

        if (food == 0){
            System.out.println("You win! Final python length is " + pLength);
        }else if (food > 0 && pLength != -1){
            System.out.printf("You lose! There is still %d food to be eaten.%n", food);
        }else {
            System.out.println("You lose! Killed by an enemy!");
        }
    }

    private static void movePython(int newRow, int newCol, char[][] matrix) {
        if (isOutOfBounds(newRow, newCol, matrix)){
            int[] newIndexes = flipSnake(matrix.length, newRow, newCol);
            newRow = newIndexes[0];
            newCol = newIndexes[1];
        }

        if (matrix[newRow][newCol] == 'f'){
            pLength++;
            food--;
        }else if ((matrix[newRow][newCol] == 'e')){
            pLength = -1;
        }

        pRow = newRow;
        pCol = newCol;
    }

    private static int[] flipSnake(int length, int r, int c) {
        int[] result = new int[2];
        if (r < 0){
            result[0] = length - 1;
            result[1] = c;
        }else if (r >= length){
            result[1] = length - 1;
        }else if (c < 0){
            result[0] = r;
            result[1] = length - 1;
        }else {
            result[0] = r;
        }

        return result;
    }

    private static boolean isOutOfBounds(int r, int c, char[][] matrix) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }
}
