import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());
        double topStudents = 0; // >= 5.00
        double veryGoodStudents = 0; // 4.00 4.99
        double goodStudents = 0; // 3.00 3.99
        double failStudents = 0; // < 3.00
        double average = 0;
        double grades = 0;
        double sum = 0;

        for (int i = 1; i <= students ; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            sum += grade;
            grades += grade;

            if (grade < 3.00){
                failStudents++;
            }
            else if (grade <= 3.99){
                goodStudents++;
            }
            else if (grade <= 4.99){
                veryGoodStudents++;
            }
            else if (grade >= 5.00){
                topStudents++;
            }
        }
        System.out.printf("Top students: %.2f%%\n", (topStudents/students) * 100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%\n", (veryGoodStudents/students) * 100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%\n", (goodStudents/students) * 100);
        System.out.printf("Fail: %.2f%%\n", (failStudents/students) * 100);
        System.out.printf("Average: %.2f", sum / students);
    }
}
