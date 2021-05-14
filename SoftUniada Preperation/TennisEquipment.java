import java.util.*;

public class TennisEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       double tennisRocket = Double.parseDouble(scanner.nextLine());
       int tennisRocketsCount = Integer.parseInt(scanner.nextLine());
       int sneakers = Integer.parseInt(scanner.nextLine());

       double tennisRocketsPrice = tennisRocket * tennisRocketsCount;
       double sneakersPrice = (tennisRocket / 6) * sneakers;
       double moreEquipment = (tennisRocketsPrice + sneakersPrice) * 0.2;
       double wholePrice =tennisRocketsPrice + sneakersPrice + moreEquipment;

       double paidByDjokovic = Math.floor(wholePrice / 8);
       double paidBySponsors = Math.ceil(wholePrice * (87.5/100.0f));

        System.out.printf("Price to be paid by Djokovic %.0f%n", paidByDjokovic);
        System.out.printf("Price to be paid by sponsors %.0f", paidBySponsors);
    }
}

