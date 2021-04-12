import java.util.Scanner;

public class GreaterNumber {
    public static <grade2> void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int grade1 = Integer.parseInt(scanner.nextLine());
        int grade2 = Integer.parseInt(scanner.nextLine());

        if (grade1 > grade2) {
            System.out.println(grade1);
        }
        else  {
            System.out.println(grade2);
        }
    }
}
