import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int juniors = Integer.parseInt(scanner.nextLine());
        int seniors = Integer.parseInt(scanner.nextLine());
        String traceType = scanner.nextLine();

        double juniorsTax = 0;
        double seniorsTax = 0;
        double sum = 0;
        double crossCountryParticipants = 0;

        switch (traceType) {
            case "trail":
                juniorsTax = juniors * 5.50;
                seniorsTax = seniors * 7;
                sum = (juniorsTax + seniorsTax) * 0.95;
                break;

            case "cross-country":
                juniorsTax = juniors * 8;
                seniorsTax = seniors * 9.50;
                crossCountryParticipants = juniors + seniors;
                sum = (juniorsTax + seniorsTax) * 0.95;
                if (crossCountryParticipants >= 50){
                    sum = sum * 0.75;
                }
                break;

            case "downhill":
                juniorsTax = juniors * 12.25;
                seniorsTax = seniors * 13.75;
                sum = (juniorsTax + seniorsTax) * 0.95;
                break;

            case "road":
                juniorsTax = juniors * 20;
                seniorsTax = seniors * 21.50;
                sum = (juniorsTax + seniorsTax) * 0.95;
                break;
        }
        System.out.printf("%.2f", sum);
    }
}
