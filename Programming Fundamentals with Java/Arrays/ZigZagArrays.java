import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        for (int i = 1; i <= n; i++) {
            int number1 = scanner.nextInt();
            int number2 = scanner.nextInt();

            if (i % 2 == 0){
                    secondArray[i - 1] = number1;
                    firstArray[i - 1] = number2;
            }else {
                secondArray[i - 1] = number2;
                firstArray[i - 1] = number1;
            }

        }

        for (int x: firstArray) {
            System.out.print(x + " ");
        }
        System.out.println();

        for (int y: secondArray){
            System.out.print(y + " ");
        }
    }
}
