import java.util.Scanner;

public class FruitMarket {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                double strawberryPrice = Double.parseDouble(scanner.nextLine());
                double bananasKg = Double.parseDouble(scanner.nextLine());
                double orangesKg = Double.parseDouble(scanner.nextLine());
                double rassberriesKg = Double.parseDouble(scanner.nextLine());
                double strawberriesKg = Double.parseDouble(scanner.nextLine());

                double rassberriesPrice = strawberryPrice * 0.50; // 24.0
                double orangesPrice = rassberriesPrice - (0.40 * rassberriesPrice); // 14.40
                double bananasPrice = rassberriesPrice - (0.80 * rassberriesPrice); // 4.80

                double rassberriesSum = rassberriesKg * rassberriesPrice;
                double orangesSum = orangesKg * orangesPrice;
                double bananasSum = bananasKg * bananasPrice;
                double strawberrySum = strawberriesKg * strawberryPrice;

                double wholeSum = strawberrySum + rassberriesSum + orangesSum + bananasSum;

                //  System.out.printf("%2f.", wholeSum);
                System.out.printf("%2f.", wholeSum);
        }
}