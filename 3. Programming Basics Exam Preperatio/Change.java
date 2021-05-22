import java.util.Scanner;

public class Change {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int bitcoins = Integer.parseInt(scanner.nextLine());
        double chineseYuan = Double.parseDouble(scanner.nextLine());
        double comission = Double.parseDouble(scanner.nextLine());

        double euro = 0;
        double euro1 = 0;
        double result = 0;

        bitcoins = bitcoins * 1168; // leva
        chineseYuan = (chineseYuan * 0.15) * 1.76; // leva
        euro1 = (bitcoins + chineseYuan) / 1.95;
        euro = euro1/100*comission;

        result = euro1 - euro;

        System.out.printf("%.2f", result);
    }
}
