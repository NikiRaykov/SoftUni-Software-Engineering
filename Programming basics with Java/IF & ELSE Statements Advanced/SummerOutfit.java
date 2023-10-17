import java.util.Scanner;

public class SummerOutfit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int degrees = Integer.parseInt(scanner.nextLine());
        String timeOfDay = scanner.nextLine();
        String outfit = "";
        String shoes = "";

        if (degrees >= 10 && degrees <= 18) {
            if (timeOfDay.equals("Morning")) {
                outfit = "Sweatshirt";
                shoes = "Sneakers";
                System.out.printf("It's %d degrees, get your %s and %s.", degrees, outfit, shoes);
            } else if (timeOfDay.equals("Afternoon") || timeOfDay.equals("Evening")) {
                outfit = "Shirt";
                shoes = "Moccasins";
                System.out.printf("It's %d degrees, get your %s and %s.", degrees, outfit, shoes);
            }
        }
        if (degrees > 18 && degrees <= 24) {
            if (timeOfDay.equals("Morning") || timeOfDay.equals("Evening")) {
                outfit = "Shirt";
                shoes = "Moccasins";
                System.out.printf("It's %d degrees, get your %s and %s.", degrees, outfit, shoes);
            } else if (timeOfDay.equals("Afternoon")) {
                outfit = "T-Shirt";
                shoes = "Sandals";
                System.out.printf("It's %d degrees, get your %s and %s.", degrees, outfit, shoes);
            }
        }
        if (degrees >= 25) {
            if (timeOfDay.equals("Morning")) {
                outfit = "T-Shirt";
                shoes = "Sandals";
                System.out.printf("It's %d degrees, get your %s and %s.", degrees, outfit, shoes);
            } else if (timeOfDay.equals("Afternoon")) {
                outfit = "Swim Suit";
                shoes = "Barefoot";
                System.out.printf("It's %d degrees, get your %s and %s.", degrees, outfit, shoes);
            } else if (timeOfDay.equals("Evening")) {
                outfit = "Shirt";
                shoes = "Moccasins";
                System.out.printf("It's %d degrees, get your %s and %s.", degrees, outfit, shoes);
            }
        }
    }
}
