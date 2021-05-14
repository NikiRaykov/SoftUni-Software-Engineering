import java.util.*;

public class BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int taxForWholeYear = Integer.parseInt(scanner.nextLine());
       double basketballSneakers = taxForWholeYear - (taxForWholeYear * (40.0f/100.0f));
       double basketballTracksuit = basketballSneakers - (basketballSneakers * (20.0f/100.0f));
       double basketballBall = basketballTracksuit * (25.0f/100.0f);
       double basketBallAccessories = basketballBall * (20.0f/100.0f);
       double wholeSum = basketballSneakers + basketballTracksuit + basketballBall + basketBallAccessories + taxForWholeYear;
        System.out.printf("%.2f", wholeSum);
    }
}

