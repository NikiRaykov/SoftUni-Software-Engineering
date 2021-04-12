import java.util.Scanner;

public class GraduationPartTwo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

       String name = scanner.nextLine();  // name of the student
       int count = 1; // 1-12 because we have 12 grades in school
       double excluded = 0; // how many times the student is excluded
       double sum = 0;

        while (count <= 12){
            double grade = Double.parseDouble(scanner.nextLine());  // grades of the student
            sum += grade;

            if (grade < 4.00){
                excluded++;
            }
            else {
                count++;
            }

            if (excluded >1){
                break;
            }
        }
        if (excluded > 1){
            System.out.printf("%s has been excluded at %d grade", name, count);
        }
        else {
            System.out.printf("%s graduated. Average grade: %.2f", name, sum / 12);
        }
    }
}
