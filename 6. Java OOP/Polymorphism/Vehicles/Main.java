import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));

        tokens = scanner.nextLine().split("\\s+");

        Vehicle truck = new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));

        int commands = Integer.parseInt(scanner.nextLine());

        while (commands-- > 0) {
            String[] commandsTokens = scanner.nextLine().split("\\s+");
            double argument = Double.parseDouble(commandsTokens[2]);

            if (commandsTokens[0].equals("Drive")) {
                if (commandsTokens[1].equals("Car")) {
                    System.out.println(car.drive(argument));
                } else if (commandsTokens[1].equals("Truck")) {
                    System.out.println(truck.drive(argument));
                }
            } else if (commandsTokens[0].equals("Refuel")) {
                if (commandsTokens[1].equals("Car")) {
                    car.refuel(argument);
                } else if (commandsTokens[1].equals("Truck")) {
                    truck.refuel(argument);
                }
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}

