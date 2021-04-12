import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String roomType = scanner.nextLine();
        String review = scanner.nextLine();

        int nights = days - 1;
        double result = 0;
        if (roomType.equals("room for one person")){
            result = 18 * nights;
        }else if (roomType.equals("apartment")){
            result = 25 * nights;
            if (days < 10){
                result = result - (result * 0.3);
            }else if (days < 15){
                result = result * 0.65;
            }else if (days > 15){
                result = result * 0.5;
            }
        }
        else if (roomType.equals("president apartment")){
            result = 35 * nights;
            if (days < 10){
                result = result * 0.9;
            }else if (days < 15){
                result = result * 0.85;
            }else if (days > 15){
                result = result * 0.8 ;
            }
        }
        if (review.equals("positive")){
            result = result * 1.25;
        }
        else {
            result = result * 0.9;
        }
        System.out.printf("%.2f", result);
    }
}
