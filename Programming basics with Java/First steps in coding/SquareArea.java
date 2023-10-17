import java.util.Scanner;

public class SquareArea {
        public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);

                String input = scan.nextLine();

                int a = Integer.parseInt(input);

                System.out.println(a*a);
        }

}