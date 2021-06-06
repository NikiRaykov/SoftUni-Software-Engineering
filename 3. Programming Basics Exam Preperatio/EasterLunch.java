import java.util.Scanner;

public class EasterLunch {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int easterCakes = Integer.parseInt(scanner.nextLine());
        int eggs = Integer.parseInt(scanner.nextLine());
        int kgs = Integer.parseInt(scanner.nextLine());

        double easterCakesPrice = 0.0;
        double eggsPrice = 0.0;
        double kgPrice = 0.0;
        double eggsPaintPrice = 0;
        double wholeSum = 0.0;

        easterCakesPrice = easterCakes * 3.20;
        eggsPrice = eggs * 4.35;
        kgPrice = kgs * 5.40;
        eggsPaintPrice = (eggs * 12) * 0.15;

        wholeSum = easterCakesPrice + eggsPrice + kgPrice + eggsPaintPrice;

        System.out.printf("%.2f", wholeSum);
    }
}

