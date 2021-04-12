import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] first = new int[n];
        int[] second = new int[n];

        for (int i = 1; i <= n; i++) {
            String[] line = scanner.nextLine().split(" ");

            if (i % 2 == 0){
                first[i - 1] = Integer.parseInt(line[1]);
                second[i - 1] = Integer.parseInt(line[0]);
            }else {
                first[i - 1] = Integer.parseInt(line[0]);
                second[i - 1] = Integer.parseInt(line[1]);
            }
        }

        for (int j : first) {
            System.out.print(j + " ");
        }
        System.out.println();

        for (int k : second){
            System.out.print(k + " ");
        }
    }
}
