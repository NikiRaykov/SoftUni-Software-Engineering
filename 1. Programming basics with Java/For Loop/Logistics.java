import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int packagesNum = Integer.parseInt(scanner.nextLine()); // броя на товарите за превоз
        int wholePackagesTons = 0;
        double averageTons;
        int priceVan = 0;
        int priceTruck = 0;
        int priceTrain = 0;
        double sumTonsPerVan = 0;
        double sumTonsTruck = 0;
        double sumTonsTrain = 0;

        for (int i = 1; i <= packagesNum; i++) {
            int tons = Integer.parseInt(scanner.nextLine()); // всеки един товар на отделен ред – тонажа на товара
            wholePackagesTons += tons;

            if (tons <= 3) {
                priceVan += tons * 200;
                sumTonsPerVan += tons;

            } else if (tons <= 11) {
                priceTruck += tons * 175;
                sumTonsTruck += tons;

            } else if (tons >= 12) {
                priceTrain += tons * 120;
                sumTonsTrain += tons;
            }

        }
        averageTons = (double)(priceVan + priceTruck + priceTrain) / wholePackagesTons;
        sumTonsPerVan = (sumTonsPerVan / wholePackagesTons) * 100;
        sumTonsTruck = (sumTonsTruck / wholePackagesTons) * 100;
        sumTonsTrain = (sumTonsTrain / wholePackagesTons) * 100;
        System.out.printf("%.2f%n", averageTons);
        System.out.printf("%.2f%%\n", sumTonsPerVan);
        System.out.printf("%.2f%%\n", sumTonsTruck);
        System.out.printf("%.2f%%", sumTonsTrain);
    }
}