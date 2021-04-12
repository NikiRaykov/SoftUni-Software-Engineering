import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine()); // the amount of money Ivo Cho has
        int students = Integer.parseInt(scanner.nextLine()); // how many students they are
        double priceOfLightSabers = Double.parseDouble(scanner.nextLine()); // for a single saber
        double priceOfRobes = Double.parseDouble(scanner.nextLine()); // for a single robe
        double priceOfBelts = Double.parseDouble(scanner.nextLine()); // for a single belt

        double beltsPrice = 0.0; double robesPrice = 0.0; double sabersPrice = 0.0; double wholeSum = 0.0; int freeBelts = 0;

        sabersPrice = priceOfLightSabers * (students + Math.ceil((students / 100.0f) * 10.0f));
        robesPrice = priceOfRobes * students;


        if (students >= 6){      // every sixth belt is free
            freeBelts = students / 6;
            beltsPrice = priceOfBelts * (students - freeBelts);
        }else {
            beltsPrice = priceOfBelts * students;
        }

        wholeSum = beltsPrice + robesPrice + sabersPrice;

        if (wholeSum <= money){
            System.out.printf("The money is enough - it would cost %.2flv.", wholeSum);
        }else {
            System.out.printf("Ivan Cho will need %.2flv more.", wholeSum - money);
        }

    }
}
