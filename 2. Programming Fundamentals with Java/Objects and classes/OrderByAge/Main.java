package OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Order> personDetails = new ArrayList<>();
        String input;

        while (!"End".equals(input = scanner.nextLine())){
            String[] details = input.split(" ");
            Order person = new Order(details[0], details[1], Integer.parseInt(details[2]));

            personDetails.add(person);
        }
        personDetails.stream().sorted(Comparator.comparingDouble(Order::getAge)).forEach(data -> System.out.println(data.output()));
    }
}
