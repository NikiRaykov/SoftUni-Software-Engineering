import java.util.Scanner;

public class Scholarship1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double income = Double.parseDouble(scanner.nextLine()); // доход
        double averageGrade = Double.parseDouble(scanner.nextLine()); // среден успех
        double minWage = Double.parseDouble(scanner.nextLine()); // Мин работна заплата
        boolean iselidgable = false;
        double scholarshipExcellent = 0;
        double socialScholarship = 0;


        if (averageGrade >= 5.5) {
            scholarshipExcellent = averageGrade * 25;
            iselidgable = true;
        }
        if (income < minWage && averageGrade > 4.5) {
             socialScholarship = minWage * 0.35;
             iselidgable = true;
        }
        if (socialScholarship == 0 && scholarshipExcellent == 0){
            System.out.println("You cannot get a scholarship!");
        }
        if (scholarshipExcellent > socialScholarship) {
            System.out.println("You get a scholarship for excellent results " + Math.round(scholarshipExcellent) + "BGN");
        }
        else if (scholarshipExcellent < socialScholarship){
            System.out.println("You get a Social scholarship "+ Math.round(socialScholarship) + " BGN");
        }
    }
}

