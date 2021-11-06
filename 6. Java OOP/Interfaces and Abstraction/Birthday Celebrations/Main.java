import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Robot> robots =  new ArrayList<>();
        List<Citizen> citizens =  new ArrayList<>();
        List<Pet> pets =  new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Pet":
                    String petName = tokens[1];
                    String petBirthDate = tokens[2];
                    pets.add(new Pet(petName, petBirthDate));
                    break;
                case "Citizen":
                    String name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String birthDate = tokens[4];
                    citizens.add(new Citizen(name, age, id, birthDate));
                    break;
                case "Robot":
                    String robotId = tokens[1];
                    String robotModel = tokens[2];
                    robots.add(new Robot(robotId, robotModel));
                    break;
            }

            input = scanner.nextLine();
        }

            String year = scanner.nextLine();

        for (Citizen citizen : citizens) {
            if (citizen.getBirthDate().endsWith(year)) {
                System.out.println(citizen.getBirthDate());
            }
        }

        for (Pet pet : pets) {
            if (pet.getBirthDate().endsWith(year)) {
                System.out.println(pet.getBirthDate());
            }
        }
    }
}
