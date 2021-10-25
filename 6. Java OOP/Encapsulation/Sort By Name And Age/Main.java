import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] personInfo = scanner.nextLine().split("\\s+");
            Person person = new Person(personInfo[0], personInfo[1],
                    Integer.parseInt(personInfo[2]));

            personList.add(person);
        }

        Collections.sort(personList, (firstPerson, secondPerson) -> {
           int comp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

           if (comp != 0){
               return comp;
           }else {
               return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
           }
        });

        for (Person person : personList) {
            System.out.println(person.toString());
        }
    }
}
