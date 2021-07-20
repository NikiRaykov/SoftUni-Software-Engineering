import java.util.Scanner;

public class Volleyball {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String year = scan.nextLine();
        int holiday = Integer.parseInt(scan.nextLine());
        int weekend = Integer.parseInt(scan.nextLine());

        double games = ((48.0 - weekend) * (3.0 / 4) + weekend + (holiday * (2.0 / 3)));

        if (year.equals("leap")) {
            games *= 1.15;
        }
        System.out.printf("%.0f", Math.floor(games));
    }
}
