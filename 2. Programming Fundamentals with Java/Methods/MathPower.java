import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());
        double result =  numberPower(number, power);
        System.out.print(new DecimalFormat("0.####"). format(numberPower(number, power)));
    }
    public static double numberPower(double number, int power){
        return Math.pow(number, power);
    }
}
