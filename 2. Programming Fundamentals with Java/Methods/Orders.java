import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        price(product, quantity);

    }
        private static void price(String product, double quantity){

                switch (product){
                    case "water":
                        System.out.printf("%.2f", quantity);
                        break;

                    case "snacks":
                        System.out.printf("%.2f", quantity * 2.00);
                        break;

                    case "coke":
                        System.out.printf("%.2f", quantity * 1.40);
                        break;

                    case "coffee":
                        System.out.printf("%.2f", quantity * 1.50);
                        break;
                }
        }
}
