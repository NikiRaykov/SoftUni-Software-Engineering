import java.util.Scanner;

public class EasterBake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int easterBread = Integer.parseInt(scanner.nextLine());
        int maxFlourUsed = 0; int maxSugarUsed = 0; int wholeSugarUsed = 0; int wholeFlourUsed = 0;
        double sugarPack = 0; double flourPack = 0;

        for (int i = 0; i < easterBread; i++) {
            int sugarUsed = Integer.parseInt(scanner.nextLine()); // in grams
            int flourUsed = Integer.parseInt(scanner.nextLine()); // in grams

            if (sugarUsed > maxSugarUsed){
                maxSugarUsed = sugarUsed;
            }

            if (flourUsed > maxFlourUsed){
                maxFlourUsed = flourUsed;
            }

            wholeSugarUsed += sugarUsed;
            wholeFlourUsed += flourUsed;

        }
        sugarPack = Math.ceil((double) wholeSugarUsed / 950);
        flourPack = Math.ceil((double) wholeFlourUsed / 750);

        System.out.printf("Sugar: %.0f%n", sugarPack);
        System.out.printf("Flour: %.0f%n", flourPack);
        System.out.printf("Max used flour is %d grams, max used sugar is %d grams.", maxFlourUsed, maxSugarUsed);
    }
}
