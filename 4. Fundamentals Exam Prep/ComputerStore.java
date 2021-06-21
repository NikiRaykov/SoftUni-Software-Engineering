import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine(); double price;
        double taxes = 0.0; double totalPrice = 0;

        while (!command.equals("special") && !command.equals("regular")){
            price = Double.parseDouble(command);

            if (price > 0){
                totalPrice += price;
                taxes += price * 0.2;
            }else {
                System.out.println("Invalid price!");
            }

            command = scanner.nextLine();
        }

        if (totalPrice == 0){
            System.out.println("Invalid order!");
            return;
        }

        System.out.println("Congratulations you've just bought a new computer!");
        System.out.printf("Price without taxes: %.2f$%n", totalPrice);
        System.out.printf("Taxes: %.2f$%n", taxes);
        System.out.println("-----------");
        totalPrice += taxes;
        if (command.equals("special")){
            System.out.printf("Total price: %.2f$", totalPrice * 0.9);
        }else {
            System.out.printf("Total price: %.2f$", totalPrice);
        }
    }
}
