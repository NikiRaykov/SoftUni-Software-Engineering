import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String first = scanner.nextLine();
        String second = scanner.nextLine();
        String third = scanner.nextLine();

        String string1 = ""; StringBuilder string2 = new StringBuilder();

        string1 = first + " " + second + " " + third;

        string2.append(string1);
        string2.reverse();


        System.out.println(string2);
    }
}
