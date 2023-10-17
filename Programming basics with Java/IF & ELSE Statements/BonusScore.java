import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int points = Integer.parseInt(scanner.nextLine());
        double bonus = 0;

        if (points <= 100) {
            bonus = 5;
        } else if (points > 1000) {
            bonus = points * 0.10;
        } else {
            bonus = points * 0.20;
        }

        if (points % 2 == 0) {
            bonus += 1;
        } else if (points % 10 == 5) {
            bonus = bonus + 2; // bonus += 2
        }
        System.out.println(bonus);
        System.out.println(bonus + points);
    }
}
