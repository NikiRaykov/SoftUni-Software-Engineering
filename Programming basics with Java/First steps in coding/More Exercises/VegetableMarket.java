import java.util.Scanner;

public class VegetableMarket {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double money = 1.94;

        double vegetablesPrice = Double.parseDouble(scanner.nextLine()); // 0.194
        double fruitsPrice = Double.parseDouble(scanner.nextLine()); // 19.4
        double vegetablesKg = Double.parseDouble(scanner.nextLine());
        double fruitsKg = Double.parseDouble(scanner.nextLine());



        double vegetablesSum = vegetablesPrice * vegetablesKg;
        double fruitsSum = fruitsPrice * fruitsKg;
        double wholeSum = (vegetablesSum + fruitsSum) / money;


        System.out.printf("%.2f", wholeSum);
    }

}