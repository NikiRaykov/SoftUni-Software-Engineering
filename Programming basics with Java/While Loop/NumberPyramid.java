import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int counter  = 1; boolean isBigger = false;

        for (int rows = 1; rows <= n; rows++) {
            for (int column = 1; column <= rows; column++) {
                counter++;
                if (counter > n){
                    isBigger = true;
                    break;
                }else {
                    System.out.println(column);
                }
            }
        }
    }
}
