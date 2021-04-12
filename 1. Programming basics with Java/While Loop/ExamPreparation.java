import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int badGradesLimit = Integer.parseInt(scanner.nextLine());
        int badGradeCount = 0;
        double avg = 0.0;
        double average = 0.0;
        int gradesCount = 0;
        String lastProblem = "";

        String problemName = scanner.nextLine();
        while (!problemName.equals("Enough")){
            int grade = Integer.parseInt(scanner.nextLine());

            if (grade <= 4){
                badGradeCount++;
                if (badGradeCount == badGradesLimit){
                    break;
                }
            }
            gradesCount++;
            avg += grade;
            average = avg / gradesCount;
            lastProblem = problemName;
            problemName = scanner.nextLine();
        }
        if (problemName.equals("Enough")){
            System.out.printf("Average score: %.2f%n", average);
            System.out.printf("Number of problems: %d%n", gradesCount);
            System.out.printf("Last problem: %s", lastProblem);
        }
        else if (badGradeCount == badGradesLimit){
            System.out.printf("You need a break, %d poor grades.", badGradeCount);
        }
    }
}