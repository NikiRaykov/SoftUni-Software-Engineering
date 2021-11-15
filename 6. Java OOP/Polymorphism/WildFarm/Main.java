package WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();
        Animal animal;
        Food food;

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s");

            animal = createAnimal(tokens);
            food = getFood(scanner);

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            animals.add(animal);

            command = scanner.nextLine();
        }

       animals.forEach(System.out::println);
    }

    private static Food getFood(Scanner scanner) {
        String[] foodGiven = scanner.nextLine().split("\\s+");
        String foodType = foodGiven[0];
        int foodQuantity = Integer.parseInt(foodGiven[1]);

        switch (foodType) {
            case "Meat":
                return new Meat(foodQuantity);
            case "Vegetable":
                return new Vegetable(foodQuantity);
            default:
                throw new IllegalArgumentException("No such food type");
        }
    }

    private static Animal createAnimal(String[] tokens) {
        String animalType = tokens[0];
        String animalName = tokens[1];
        double animalWeight = Double.parseDouble(tokens[2]);
        String animalLivingRegion = tokens[3];
        switch (animalType) {
            case "Mouse":
                return new Mouse(animalType, animalName, animalWeight, animalLivingRegion);
            case "Cat":
                String catBreed = tokens[4];
                return new Cat(animalType, animalName, animalWeight, animalLivingRegion, catBreed);
            case "Zebra":
                return new Zebra(animalType, animalName, animalWeight, animalLivingRegion);
            case "Tiger":
                return new Tiger(animalType, animalName, animalWeight, animalLivingRegion);
            default:
                throw new IllegalArgumentException("No such animal");
        }
    }
}
