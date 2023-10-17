import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char s = scanner.nextLine().charAt(0);

        if (Character.isUpperCase(s)){
            System.out.println("upper-case");
        }else {
            System.out.println("lower-case");
        }
    }
}
