import java.util.Scanner;

public class MovieDestination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double movieBudget = Double.parseDouble(scanner.nextLine());
        String destination = scanner.nextLine();
        String season = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());

        double price = 0.0;

        switch (destination){
            case "Dubai":
                if (season.equals("Winter")){
                    price = days * 45000;
                }else if (season.equals("Summer")){
                    price = days * 40000;
                }

                price -= price * (30.0f/100.0f);
                break;

            case "Sofia":
                if (season.equals("Winter")){
                    price = days * 17000;
                }else if (season.equals("Summer")){
                    price = days * 12500;
                }

                price += price * (25.0f/100.0f);
                break;

            case "London":
                if (season.equals("Winter")){
                    price = days * 24000;
                }else if (season.equals("Summer")){
                    price = days * 20250;
                }
                break;
        }
        if (price <= movieBudget){
            System.out.printf("The budget for the movie is enough! We have %.2f leva left!", movieBudget - price);
        }else {
            System.out.printf("The director needs %.2f leva more!", price - movieBudget);
        }
    }
}
