import java.util.Scanner;

public class CircleAreaAndPerimeter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double r = Double.parseDouble(scanner.nextLine());

        double S = Math.PI * r * r;
        double P = 2 * Math.PI * r;

        System.out.printf("%.2f\n", S);
        System.out.printf("%.2f", P);
    }
}