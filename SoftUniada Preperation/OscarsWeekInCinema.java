import java.util.Scanner;

public class OscarsWeekInCinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movieName = scanner.nextLine();
        String hallName = scanner.nextLine();
        int ticketsBought = Integer.parseInt(scanner.nextLine());

        double income = 0;

        switch (movieName){
            case "A Star Is Born":
                if (hallName.equals("normal")){
                    income = ticketsBought * 7.50;
                }else if (hallName.equals("luxury")){
                    income = ticketsBought * 10.50;
                }else if (hallName.equals("ultra luxury")){
                    income = ticketsBought * 13.50;
                }
                break;

            case "Bohemian Rhapsody":
                if (hallName.equals("normal")){
                    income = ticketsBought * 7.35;
                }else if (hallName.equals("luxury")){
                    income = ticketsBought * 9.45;
                }else if (hallName.equals("ultra luxury")){
                    income = ticketsBought * 12.75;
                }
                break;

            case "Green Book":
                if (hallName.equals("normal")){
                    income = ticketsBought * 8.15;
                }else if (hallName.equals("luxury")){
                    income = ticketsBought * 10.25;
                }else if (hallName.equals("ultra luxury")){
                    income = ticketsBought * 13.25;
                }
                break;

            case "The Favourite":
                if (hallName.equals("normal")){
                    income = ticketsBought * 8.75;
                }else if (hallName.equals("luxury")){
                    income = ticketsBought * 11.55;
                }else if (hallName.equals("ultra luxury")){
                    income = ticketsBought * 13.95;
                }
                break;
        }
        System.out.printf("%s -> %.2f lv.", movieName, income);
    }
}
