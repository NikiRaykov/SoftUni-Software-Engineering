import java.util.Scanner;

public class Fishland {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        double mackerelPrice = Double.parseDouble(scanner.nextLine()); // скумрия
        double toyPrice = Double.parseDouble(scanner.nextLine()); // цаца
        double bonitoKg = Double.parseDouble(scanner.nextLine()); // паламуд
        double horseMackerelKg = Double.parseDouble(scanner.nextLine()); // сафрид
        double musselsKg = Double.parseDouble(scanner.nextLine()); // миди

        double bonitoPrice = mackerelPrice + (mackerelPrice * 0.60);
        double horseMackerelPrice = toyPrice + (toyPrice * 0.80);
        double musselsPrice = 7.50;

        double bonitoSum = bonitoKg * bonitoPrice;
        double horseMackerelSum = horseMackerelKg * horseMackerelPrice;
        double musselsSum = musselsKg * musselsPrice;

        double wholeSum = bonitoSum + horseMackerelSum + musselsSum;

        System.out.printf("%.2f", wholeSum);
    }

}