package animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animalList = new ArrayList<>();
        String animalType;

        while (!"Beast!".equals(animalType = scanner.nextLine())) {
            String[] input = scanner.nextLine().split("\\s+");

            String name = input[0];
            int age = Integer.parseInt(input[1]);
            String gender = input[2];

            try {
                switch (animalType) {
                    case "Dog":
                        animalList.add(new Dog(name, age, gender));
                        break;
                    case "Frog":
                        animalList.add(new Frog(name, age, gender));
                        break;
                    case "Cat":
                        animalList.add(new Cat(name, age, gender));
                        break;
                    case "Kitten":
                        animalList.add(new Kitten(name, age));
                        break;
                    case "Tomcat":
                        animalList.add(new Tomcat(name, age));
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        animalList.forEach(System.out::println);
    }
}
