import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int maxNum = Integer.MIN_VALUE;

        while (!command.equals("Stop")){
            int num = Integer.parseInt(command);

            if (num > maxNum){
                maxNum = num;
            }
            command = scanner.nextLine();
        }
        System.out.println(maxNum);
    }
}
