import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());
        int product = 0;

        if (multiplier > 10){
            product = n * multiplier;
            System.out.printf("%d X %d = %d", n,multiplier,product);
        }else {
            for (int i = n; i <=n; i++) {
                for (int j = multiplier; j <=10; j++) {
                    product = i * j;
                    System.out.printf("%d X %d = %d%n", i,j,product);
                }
            }
        }
    }
}
