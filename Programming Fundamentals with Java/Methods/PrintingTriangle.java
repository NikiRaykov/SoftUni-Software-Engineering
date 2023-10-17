import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < n - 1; j++) {
                System.out.println(i);
                System.out.print(j + " ");
            }
        }
    }

    public static void printTriangle(){

    }
}
