import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printFigure(n);
    }

    private static void printFigure(int n){
        printTopOfRhombus(n);
        printMiddlePartOfRhombus(n);
        printBottomPartOfRhombus(n);
    }

    private static void printBottomPartOfRhombus(int n) {
        for (int r = 1; r < n; r++) {
            for (int i = 0; i < r; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < n - r; i++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    private static void printMiddlePartOfRhombus(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printTopOfRhombus(int n) {
        for (int r = 1; r < n; r++) {
            for (int i = 0; i < n - r; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < r; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
