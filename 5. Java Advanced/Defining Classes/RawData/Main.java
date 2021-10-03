package RawData;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carsToCheck = Integer.parseInt(scanner.nextLine());

        List<Car> carData = new ArrayList<>();

        for (int i = 0; i < carsToCheck; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Car car = new Car(input[0], Integer.parseInt(input[2]), input[4],Double.parseDouble(input[5]),
                    Double.parseDouble(input[7]), Double.parseDouble(input[9]), Double.parseDouble(input[11]));

            carData.add(car);
        }
        String cargo = scanner.nextLine();

        if (cargo.equals("fragile")){
            carData.stream().filter(e -> e.getCargoType().equals("fragile") && e.tirePressure())
                    .forEach(System.out::println);
        }else if (cargo.equals("flamable")){
            carData.stream().filter(e -> e.getCargoType().equals("flamable") && e.getEngine() > 250)
                    .forEach(System.out::println);
        }
    }
}

