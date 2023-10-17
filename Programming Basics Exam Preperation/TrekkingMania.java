import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int groups = Integer.parseInt(scanner.nextLine());
        double counterMusala = 0.0; double allClimbers = 0.0; double counterEverest = 0.0; double counterK2 = 0.0;
        double counterMonblan = 0.0; double counterKilimandjaro = 0.0;

        for (int i = 1; i <= groups ; i++) {
            int peopleInGroup = Integer.parseInt(scanner.nextLine());
            allClimbers += peopleInGroup;

            if (peopleInGroup <= 5){
                counterMusala += peopleInGroup;
            }else if (peopleInGroup <= 12){
                counterMonblan += peopleInGroup;
            }else if (peopleInGroup <= 25){
                counterKilimandjaro += peopleInGroup;
            }else if (peopleInGroup <= 40){
                counterK2 += peopleInGroup;
            }else {
                counterEverest += peopleInGroup;
            }
        }
        System.out.printf("%.2f%%%n", (counterMusala/allClimbers) * 100);
        System.out.printf("%.2f%%%n", (counterMonblan/allClimbers) * 100);
        System.out.printf("%.2f%%%n", (counterKilimandjaro/allClimbers) * 100);
        System.out.printf("%.2f%%%n", (counterK2/allClimbers) * 100);
        System.out.printf("%.2f%%", (counterEverest/allClimbers) * 100);
    }
}