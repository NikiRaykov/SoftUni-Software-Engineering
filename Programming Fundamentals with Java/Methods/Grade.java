import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
            myMethod();
    }

    public static void myMethod(){
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());

        if (grade >= 2.00 && grade <= 2.99){
            System.out.print("Fail");
        }else if (grade >= 3.00 && grade <= 3.49){
            System.out.print("Poor");
        }else if (grade >= 3.50 && grade <= 4.49){
            System.out.print("Good");
        }else if (grade >= 4.50 && grade <= 5.49){
            System.out.print("Very good");
        }else if (grade >= 5.50 && grade <= 6.00){
            System.out.print("Excellent");
        }
    }
}
