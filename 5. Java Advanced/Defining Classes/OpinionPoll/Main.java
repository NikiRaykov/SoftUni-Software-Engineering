package OpinionPoll;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();
        Person person = null;
        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");

            if (Integer.parseInt(tokens[1]) > 30){
                person = new Person(tokens[0], Integer.parseInt(tokens[1]));
                personList.add(person);
            }
        }
        personList.sort(Comparator.comparing(Person::getName));
        personList.forEach(System.out::println);
    }
}
