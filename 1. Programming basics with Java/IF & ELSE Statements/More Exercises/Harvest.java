import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int area = Integer.parseInt(scanner.nextLine());
        double grapesQuantity = Double.parseDouble(scanner.nextLine());
        int wineLitersNeeded = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());

        double wholeGrapes = grapesQuantity * area;
        double wine = wholeGrapes * 0.40 / 2.5;
        double litersLeft = wine - wineLitersNeeded;
        double winePerWorker = litersLeft / workers;
        double litersNeeded = wineLitersNeeded - wine;

        if (wine < wineLitersNeeded){
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(litersNeeded));
        }
        else if (wine > wineLitersNeeded){
            System.out.printf("Good harvest this year! Total wine: %.0f liters.\n", Math.floor(wine));
            System.out.printf("%.0f liters left -> %.0f liters per person.", Math.ceil(litersLeft), Math.ceil(winePerWorker));
        }
    }
}