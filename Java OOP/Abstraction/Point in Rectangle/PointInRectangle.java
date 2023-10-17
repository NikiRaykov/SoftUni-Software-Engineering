import java.util.Arrays;
import java.util.Scanner;

public class PointInRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = readArray(scanner);

        Point pointA = new Point(coordinates[0], coordinates[1]);
        Point pointC = new Point(coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle(pointA, pointC);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            int[] points = readArray(scanner);

            Point p = new Point(points[0], points[1]);

            boolean isInside = rectangle.isInside(p);

            System.out.println(isInside);
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
