import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int startNumber = Integer.parseInt(scanner.nextLine()); // start
        int finalNumber = Integer.parseInt(scanner.nextLine()); // end
        int magicNum = Integer.parseInt(scanner.nextLine());

        int combinations = 0;
        int sum = 0;
        boolean flag = false;

        for (int i = startNumber; i <= finalNumber; i++) {
            for (int j = startNumber; j <= finalNumber ; j++) {
                sum = i + j;
                combinations++;

                if (sum == magicNum){
                    System.out.printf("Combination N:%d (%d + %d = %d)%n", combinations, i, j, magicNum);
                    flag = true;
                    break;
                }
            }
            if (flag){
                break;
            }
        }

        if (!flag){
            System.out.printf("%d combinations - neither equals %d", combinations, magicNum);
        }
    }
}
