import java.util.Scanner;

public class OscarsCeremony {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rent = Integer.parseInt(scanner.nextLine());

        double figurePrice = rent - (rent * (30.0f/100.0f));
        double catering = figurePrice - (figurePrice * (15.0f/100.0f));
        double sounding = catering / 2;

        double wholePrice = rent + figurePrice + catering + sounding;
        System.out.printf("%.2f", wholePrice);
    }
}
