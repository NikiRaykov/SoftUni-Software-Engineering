package Google;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashMap<String, Person> personData = new HashMap<>();

        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");
            String name = tokens[0];

            if (!personData.containsKey(name)){
                personData.put(name, new Person());
            }

            if (tokens[1].equals("company")){
                String companyName = tokens[2];
                String department = tokens[3];
                double salary = Double.parseDouble(tokens[4]);
                Company company = new Company(companyName, department, salary);

                personData.get(name).setCompany(company);
            }else if (tokens[1].equals("pokemon")){
                String pokemonName = tokens[2];
                String pokemonType = tokens[3];
                Pokemon pokemon = new Pokemon(pokemonName, pokemonType);

                personData.get(name).getPokemons().add(pokemon);
            }else if (tokens[1].equals("parents")){
                // PeterSmith parents PoshoPeshev 22/02/1920
                String parentName = tokens[2];
                String parentBirthday = tokens[3];
                Parent parent = new Parent(parentName, parentBirthday);

                personData.get(name).getParents().add(parent);
            }else if (tokens[1].equals("car")){
                String carModel = tokens[2];
                int speed = Integer.parseInt(tokens[3]);
                Car car = new Car(carModel, speed);

                personData.get(name).setCar(car);
            }else if (tokens[1].equals("children")){
                // GeorgeJohnson children SamJohnson 01/01/2001
                String childrenName = tokens[2];
                String childBirthday = tokens[3];
                Child child = new Child(childrenName, childBirthday);

                personData.get(name).getChildren().add(child);
            }

            input = scanner.nextLine();
        }

        String searchPerson = scanner.nextLine();

        System.out.println(searchPerson);

        Person personalData = personData.get(searchPerson);
        System.out.println(personalData);
    }
}
