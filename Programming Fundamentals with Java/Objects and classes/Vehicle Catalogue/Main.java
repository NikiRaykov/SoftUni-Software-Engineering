package VehicleCatalogue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static VehicleCatalogue.VehicleCatalogue.averageHorsepower;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<VehicleCatalogue> data = new ArrayList<>();

        while (!input.equals("End")){
            String[] vehicleData = input.split(" ");

            String type = vehicleData[0];
            String model = vehicleData[1];
            String color = vehicleData[2];
            int horsepower = Integer.parseInt(vehicleData[3]);

            VehicleCatalogue vehicle = new VehicleCatalogue(type, model, color, horsepower);
            data.add(vehicle);

            input = scanner.nextLine();
        }
        String model = scanner.nextLine();

        while (!model.equals("Close the Catalogue")){
            String finalModel = model;
            data.stream().filter(data1 -> data1.getModel().equals(finalModel)).
                    forEach(data1 -> System.out.println(data1.output()));

            model = scanner.nextLine();
        }

        List<VehicleCatalogue> cars = data.stream().filter(data1 -> data1.getType().equals("car")).collect(Collectors.toList());
        List<VehicleCatalogue> truck = data.stream().filter(data1 -> data1.getType().equals("truck")).collect(Collectors.toList());
        System.out.printf("Cars have average horsepower of: %.2f.%n", averageHorsepower(cars));
        System.out.printf("Trucks have average horsepower of: %.2f.", averageHorsepower(truck));
    }


}
