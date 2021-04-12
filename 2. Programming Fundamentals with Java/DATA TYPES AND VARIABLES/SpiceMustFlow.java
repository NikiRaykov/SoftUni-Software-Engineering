import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int startingYield= Integer.parseInt(scanner.nextLine());
        int days = 0; int total = 0; int leftSpice = 0;


        while (startingYield >= 100){
            days ++;

            if (days != 0){
                leftSpice = startingYield;
                startingYield -= 10;
                leftSpice -= 26;
            }
            if (days >= 1){
                total += leftSpice;
            }
        }
        System.out.println(days);
        System.out.println(total - 26);
    }
}
