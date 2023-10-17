import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());

        int power = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ('>')) {
                power += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
            } else if (power > 0 && input.charAt(i) != '>') {
                input.deleteCharAt(i);
                power--;
                i--;
            }
        }
        System.out.println(input);
    }
}
