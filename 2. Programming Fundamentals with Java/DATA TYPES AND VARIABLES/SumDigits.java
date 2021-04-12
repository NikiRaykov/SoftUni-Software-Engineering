import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0; int n;

            while (number > 0){
                sum = sum + number % 10;
                number = number / 10;
            }

        System.out.println(sum);
    }
}
