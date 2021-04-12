import java.util.Scanner;

public class Pokemon {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int pokPower = Integer.parseInt(scanner.nextLine()); // N
        int distance = Integer.parseInt(scanner.nextLine()); // between targets M
        int exhaustionFactor = Integer.parseInt(scanner.nextLine()); // Y

        int pokes = 0;

        while (pokPower > distance){
            pokPower -= distance;
            pokes ++;

            if (pokPower == distance){
                pokPower /= exhaustionFactor;
            }
        }
        System.out.println(pokPower);
        System.out.println(pokes);
    }
}
