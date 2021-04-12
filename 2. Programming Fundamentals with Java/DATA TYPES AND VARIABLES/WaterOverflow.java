import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int tankCapacity = 255; int pouredLiters = 0;

        for (int i = 1; i <= n; i++) {
            int quantity = Integer.parseInt(scanner.nextLine());
            pouredLiters +=quantity;

            if (pouredLiters>tankCapacity){
                System.out.println("Insufficient capacity!");
                pouredLiters -= quantity;
            }
        }
        System.out.println(pouredLiters);
    }
}
