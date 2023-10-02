package implementations;

public class TheMatrix {
    private char[][] matrix;
    private char fillChar;
    private char toBeReplaced;
    private char startChar;
    private int startRow;
    private int startCol;

    public TheMatrix(char[][] matrix, char fillChar, int startRow, int startCol) {
        this.matrix = matrix;
        this.fillChar = fillChar;
        this.startRow = startRow;
        this.startCol = startCol;
        this.toBeReplaced = this.matrix[this.startRow][this.startCol];
    }

    public void solve() {
        fillMatrix(this.startRow, this.startCol);
    }

    private void fillMatrix(int row, int col) {
        if (isOutOfBounds(row, col) || this.matrix[row][col] != this.startChar) {
            return;
        }

        this.matrix[row][col] = this.fillChar;

        System.out.println(this.toOutputString());

        this.fillMatrix(row + 1, col);
        this.fillMatrix(row, col + 1);
        this.fillMatrix(row - 1, col);
        this.fillMatrix(row, col - 1);

    }

    private boolean isOutOfBounds(int row, int col) {
       return row < 0 || row >= this.matrix.length || col < 0 || col >= this.matrix[row].length;
    }

    public String toOutputString() {
        StringBuilder print = new StringBuilder();
        for (int r = 0; r < this.matrix.length; r++) {
            for (int col = 0; col < this.matrix[r].length; col++) {
                print.append(matrix[r][col]);
            }
            print.append(System.lineSeparator());
        }

        return print.toString().trim();
    }
}
