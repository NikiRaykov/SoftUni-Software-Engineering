package Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Student> students = new ArrayList<>();
        while (!input.equals("end")){
            String[] studentData = input.split(" ");

            String firstName = studentData[0];
            String lastName = studentData[1];
            int age = Integer.parseInt(studentData[2]);
            String city = studentData[3];

            Student student = new Student(firstName, lastName, age, city); // object from the Student class
            students.add(student);

            input = scanner.nextLine();
        }
        String filterCity = scanner.nextLine();

        for (Student student: students){
            if (student.getHometown().equals(filterCity)){
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
}
