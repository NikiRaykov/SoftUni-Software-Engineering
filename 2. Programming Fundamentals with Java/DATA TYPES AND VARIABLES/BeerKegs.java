import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int beerKegs = Integer.parseInt(scanner.nextLine());
        double volume = 0;  String biggestKeg = ""; double biggest = 0;

        for (int i = 1; i <= beerKegs; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            volume = Math.PI * (radius * radius) * height;

            if (volume > biggest){
                biggest = volume;
                biggestKeg = model;
            }
        }
        System.out.print(biggestKeg);
    }
}
