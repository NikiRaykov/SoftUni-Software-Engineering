package OpinionPoll;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int input = Integer.parseInt(scanner.nextLine());

        List<Person> output = new LinkedList<>();

        for (int i = 0; i < input; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);



            if (age > 30){
                Person person = new Person(name, age);
                output.add(person);
            }
        }

        output.sort(Comparator.comparing(Person::getName));

        output.forEach(System.out::println);
    }
}
