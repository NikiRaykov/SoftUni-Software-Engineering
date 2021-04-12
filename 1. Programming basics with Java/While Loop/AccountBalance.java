import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sum = 0;

        while (!input.equals("NoMoreMoney")){
            double payment = Double.parseDouble(input);

            if (payment < 0){
                System.out.println("Invalid operation!");
                break;
            }
            sum += payment;

            System.out.printf("Increase: %.2f%n", payment);

            input = scanner.nextLine();

        }
        System.out.printf("Total: %.2f", sum);
    }
}
