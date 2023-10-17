import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceOfLightsaber = Double.parseDouble(scanner.nextLine());
        double priceOfRobe = Double.parseDouble(scanner.nextLine());
        double priceOfBelt = Double.parseDouble(scanner.nextLine());
        double sum; double beltPrice;

        double sabersPrice = (Math.ceil(students + (students/10.0f)) * priceOfLightsaber);
        double robesPrice = students * priceOfRobe;
        int freeBelts = students / 6;
        if (freeBelts < 1){
             beltPrice = students * priceOfBelt;
        }else {
            beltPrice = (students - freeBelts) * priceOfBelt;
        }


        sum = sabersPrice + robesPrice + beltPrice;
        if (sum <= money){
            System.out.printf("The money is enough - it would cost %.2flv.", sum);
        }else {
            System.out.printf("George Lucas will need %.2flv more.", sum - money);
        }
    }
}
