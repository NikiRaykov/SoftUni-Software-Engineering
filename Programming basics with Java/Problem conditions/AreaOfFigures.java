import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfFigure = scanner.nextLine();

        if (typeOfFigure.equals("square")) {
            double num = Double.parseDouble(scanner.nextLine());
            double result = num * num;
            System.out.printf("%.3f", result);
        } else if (typeOfFigure.equals("rectangle")) {
            double area = Double.parseDouble(scanner.nextLine());
            double width = Double.parseDouble(scanner.nextLine());

            double result = area * width;

            System.out.printf("%.3f", result);
        } else if (typeOfFigure.equals("circle")) {
            double radius = Double.parseDouble(scanner.nextLine());

            double result = radius * radius * Math.PI;

            System.out.printf("%.3f", result);
        } else if (typeOfFigure.equals("triangle")) {
            double height = Double.parseDouble(scanner.nextLine());
            double width = Double.parseDouble(scanner.nextLine());

            double result = (height * width) / 2;

            System.out.printf("%.3f", result);
        }
    }
}
