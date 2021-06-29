package OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        List<Person> person = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");

            Person personData = new Person(tokens[0], Integer.parseInt(tokens[1]));
            person.add(personData);
        }
        person.stream().filter(data -> data.getAge() > 30).sorted(Comparator.comparing(Person::getName)).forEach(data -> System.out.println(data.outPut()));
    }
}
