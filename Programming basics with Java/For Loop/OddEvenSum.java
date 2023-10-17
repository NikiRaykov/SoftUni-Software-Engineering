import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 1; i <= n ; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0){
                sumEven += num;
                sum = sumEven;
            }
            else {
                sumOdd += num;
                sum = sumOdd;
            }
        }
        if (sumEven == sumOdd){
            System.out.println("Yes");
            System.out.printf("Sum = %d", sum);
        }
        else {
            System.out.println("No");
            System.out.printf("Diff = %d", Math.abs(sumOdd - sumEven));
        }
    }
}
