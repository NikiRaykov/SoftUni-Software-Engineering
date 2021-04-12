import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String typeOfMovie = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        double income = 0.0;

        if(typeOfMovie.equals("Premiere")) {
            income = rows * columns * 12;
            System.out.printf("%.2f leva", income);
        }
        else if (typeOfMovie.equals("Normal")) {
            income = rows * columns * 7.50;
            System.out.printf("%.2f leva", income);
        }
        else if (typeOfMovie.equals("Discount")){
            income = rows * columns * 5;
            System.out.printf("%.2f leva", income);
        }
    }
}
