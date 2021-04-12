import java.time.temporal.IsoFields;
import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        int space = width * length * height; // cubic meters of room

        String input = scanner.nextLine();
        int freeCubicMeters = 0;
        int notEnoughCubicMeter = 0;
        int boxesSum = 0;

        while (!input.equals("Done")){
            int boxes = Integer.parseInt(input);
            boxesSum += boxes; // cubic meters of boxes

            if (boxesSum >= space){
                break;
            }

            input = scanner.nextLine();
        }
        int diff = Math.abs(space -boxesSum);

        if (space > boxesSum){
            System.out.printf("%d Cubic meters left.", diff);
        }
        else {
            System.out.printf("No more free space! You need %d Cubic meters more.", diff);
        }
    }
}
