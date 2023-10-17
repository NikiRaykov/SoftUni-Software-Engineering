import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();

        String input = scanner.nextLine();

        while (!input.equals("END")){
            String[] directionAndPlateNumber = input.split(", ");

            if (directionAndPlateNumber[0].equals("IN")){
                parkingLot.add(directionAndPlateNumber[1]);
            }else {
                parkingLot.remove(directionAndPlateNumber[1]);
            }

            input = scanner.nextLine();
        }

        if (!parkingLot.isEmpty()){
            for (String car: parkingLot){
                System.out.println(car);
            }
        }else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
