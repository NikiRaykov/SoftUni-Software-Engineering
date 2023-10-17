import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        nxnMatrix(number);
    }

    public static void nxnMatrix(int number){
        for (int i = 0; i < number; i++) {
            if (i >= 1){
                System.out.println();
            }
            for (int j = 0; j < number; j++) {
                System.out.print(number + " ");
            }
        }
    }
}
