import java.util.Scanner;

public class FilmPremiere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movie = scanner.nextLine();
        String moviePackage = scanner.nextLine();
        int tickets = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (movie){
            case "John Wick":
                if (moviePackage.equals("Drink")){
                    price = tickets * 12;
                }else if (moviePackage.equals("Popcorn")){
                    price = tickets * 15;
                }else if (moviePackage.equals("Menu")){
                    price = tickets * 19;
                }
                break;

            case "Star Wars":
                if (moviePackage.equals("Drink")){
                    price = tickets * 18;
                }else if (moviePackage.equals("Popcorn")){
                    price = tickets * 25;
                }else if (moviePackage.equals("Menu")){
                    price = tickets * 30;
                }

                if (tickets >= 4){
                    price -= price * (30.0f/100.0f);
                }
                break;

            case "Jumanji":
                if (moviePackage.equals("Drink")){
                    price = tickets * 9;
                }else if (moviePackage.equals("Popcorn")){
                    price = tickets * 11;
                }else if (moviePackage.equals("Menu")){
                    price = tickets * 14;
                }

                if (tickets == 2){
                    price -= price * (15.0f/100.0f);
                }
                break;
        }
        System.out.printf("Your bill is %.2f leva.", price);
    }
}
