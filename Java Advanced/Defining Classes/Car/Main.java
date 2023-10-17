package Car;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car();

        int cars = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cars; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String brand = input[0];
            String model = input[1];
            int horsePower = Integer.parseInt(input[2]);

            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            car.getInfo();
        }
    }
}