import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int currentNumber; int result = 0; int counter = 0; boolean isValid = false;

        for (int i = 1; i <= 2*number; i++) {
            int pair = 0;
            currentNumber = Integer.parseInt(scanner.nextLine());
            result = 2 * number;
            pair = result / 2;

            counter++;

            if (counter <= 2){
               int pair = 0;
               pair += currentNumber;
            }
            else if (counter <= 4){
                int pair2 = 0;
                pair2 += currentNumber;
            }
            else if (counter <= result){
                int pair3 = 0;
                pair3 += currentNumber;
            }

        }
    }
}