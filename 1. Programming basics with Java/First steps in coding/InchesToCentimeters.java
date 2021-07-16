import java.util.Scanner;

public class InchesToCentimeters {
        public static void main(String[] args){

                Scanner scan = new Scanner(System.in);
                String input = scan.nextLine();
                double inch = Double.parseDouble(input);

                double result = inch * 2.54;
                System.out.println(result);
        }
}