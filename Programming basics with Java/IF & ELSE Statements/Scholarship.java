import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    double income = Double.parseDouble(scanner.nextLine()); // доход
    double averageGrade = Double.parseDouble(scanner.nextLine()); // среден успех
    double minWage = Double.parseDouble(scanner.nextLine()); // Мин работна заплата

    if (income < minWage && averageGrade > 4.5) {
        double socialScholarship = minWage * 0.35;
        System.out.println("You get a Social scholarship "+Math.round(socialScholarship) + " BGN");
    }
    else if (averageGrade >= 5.5) {
        double scholarshipExcellent = averageGrade * 25;
        System.out.println("You get a scholarship for excellent results " + Math.round(scholarshipExcellent) + "BGN");
    }
    else {
        System.out.println("You cannot get a scholarship!");
    }

    }
    }


