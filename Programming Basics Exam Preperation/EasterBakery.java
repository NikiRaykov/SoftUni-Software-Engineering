import java.util.Scanner;

public class EasterBakery {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double flourPrice = Double.parseDouble(scanner.nextLine()); // for kg
        double flourKg = Double.parseDouble(scanner.nextLine());
        double sugarKg = Double.parseDouble(scanner.nextLine());
        int eggs = Integer.parseInt(scanner.nextLine());
        int yeast = Integer.parseInt(scanner.nextLine());

        double sugarPrice = 0; double eggsPrice = 0; double yeastPrice = 0; double flourSum = 0;
        double sugarSum = 0; double eggsSum = 0; double yeastSum = 0; double wholeSum = 0;

        sugarPrice = flourPrice * 0.75;
        eggsPrice = flourPrice + (flourPrice * 0.10);
        yeastPrice = sugarPrice * 0.20;

        flourSum = flourPrice * flourKg;
        sugarSum = sugarKg * sugarPrice;
        eggsSum = eggs * eggsPrice;
        yeastSum = yeast * yeastPrice;

        wholeSum = flourSum + sugarSum + eggsSum + yeastSum;
        System.out.printf("%.2f", wholeSum);
    }
}