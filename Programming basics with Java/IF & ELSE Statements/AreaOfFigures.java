import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a figure: square, circle, triangle,rectangle");
        String figure = scanner.nextLine();

        if (figure.equals("square")) {
            System.out.println("Choose your number: ");
            double a = scanner.nextDouble();
            System.out.printf("%.3f", a * a);
        } else if (figure.equals("circle")) {
            System.out.println("Choose your radius: ");
            double r = scanner.nextDouble();
            System.out.printf("%.3f", Math.PI * (r * r));
        }
        else if (figure.equals("triangle")) {
            System.out.println("Choose your first number: ");
            double a1 = scanner.nextDouble();
            System.out.println("Choose second number: ");
            double h = scanner.nextDouble();
            System.out.printf("%.3f", (a1 * h) / 2);
        }
        else if (figure.equals("rectangle")) {
            System.out.println("Choose your first number: ");
            double b1 = scanner.nextDouble();
            System.out.println("Choose second number: ");
            double b2 = scanner.nextDouble();
            System.out.printf("%.3f", b1 * b2);
        }else {
            System.out.println("Invalid input1");
        }
    }
}