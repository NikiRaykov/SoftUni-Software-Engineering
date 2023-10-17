import java.util.*;

public class WorldSnookerChampionship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tournamentStage = scanner.nextLine();
        String ticketType = scanner.nextLine();
        int ticketsCount = Integer.parseInt(scanner.nextLine());
        String trophyPhoto = scanner.nextLine();

        double sum = 0.0;

        switch (tournamentStage){
            case "Quarter final":
                if (ticketType.equals("Standard")){
                    sum = ticketsCount * 55.50;
                }else if (ticketType.equals("Premium")){
                    sum = ticketsCount * 105.20;
                }else if (ticketType.equals("VIP")){
                    sum = ticketsCount * 118.90;
                }

                if (sum > 4000){
                    sum -= sum * (25.0f/100.0f);
                    if (trophyPhoto.equals("Y")){
                        sum -= 40 * ticketsCount;
                    }
                }else if (sum > 2500){
                    sum -= sum * (10.0f/100.0f);
                }

                if (trophyPhoto.equals("Y")){
                    sum += 40 * ticketsCount;
                }
                break;
            case "Semi final":
                if (ticketType.equals("Standard")){
                    sum = ticketsCount * 75.88;
                }else if (ticketType.equals("Premium")){
                    sum = ticketsCount * 125.22;
                }else if (ticketType.equals("VIP")){
                    sum = ticketsCount * 300.40;
                }

                if (sum > 4000){
                    sum -= sum * (25.0f/100.0f);
                    if (trophyPhoto.equals("Y")){
                        sum -= 40 * ticketsCount;
                    }
                }else if (sum > 2500){
                    sum -= sum * (10.0f/100.0f);
                }


                if (trophyPhoto.equals("Y")){
                    sum += 40 * ticketsCount;
                }
                break;
            case "Final":
                if (ticketType.equals("Standard")){
                    sum = ticketsCount * 110.10;
                }else if (ticketType.equals("Premium")){
                    sum = ticketsCount * 160.66;
                }else if (ticketType.equals("VIP")){
                    sum = ticketsCount * 400;
                }

                if (sum > 4000){
                    sum -= sum * (25.0f/100.0f);
                    if (trophyPhoto.equals("Y")){
                        sum -= 40 * ticketsCount;
                    }
                }else if (sum > 2500){
                    sum -= sum * (10.0f/100.0f);
                }


                if (trophyPhoto.equals("Y")){
                    sum += 40 * ticketsCount;
                }

                break;
        }
        System.out.printf("%.2f", sum);
    }
}