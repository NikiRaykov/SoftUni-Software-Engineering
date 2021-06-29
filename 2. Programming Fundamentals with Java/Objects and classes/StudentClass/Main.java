package StudentClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            Student data = new Student(input[0], input[1], Double.parseDouble(input[2]));
            studentList.add(data);
        }
        studentList.stream().sorted((data1, data2) -> Double.compare(data2.getGrade(), data1.getGrade()))
                .forEach(data -> System.out.println(data.output()));
    }
}
