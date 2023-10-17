package CarConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cars = Integer.parseInt(scanner.nextLine());

        List<Car> info = new ArrayList<>();

        Car car;
        for (int i = 0; i < cars; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            if (input.length == 1){
               car = new Car(input[0]);
            }else {
                car = new Car(input[0], input[1], Integer.parseInt(input[2]));
            }

            info.add(car);
        }
        info.forEach(System.out::println);
    }
}
