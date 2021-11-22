import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] personInfo = scanner.nextLine().split("\\s+");

        String firstName = personInfo[0];
        String lastName = personInfo[1];
        int age = Integer.parseInt(personInfo[2]);

        try {
            ValidPerson person = new ValidPerson(firstName, lastName, age);
            System.out.println(person);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
