import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int minNum = Integer.MAX_VALUE;

        while (!command.equals("Stop")){
            int num = Integer.parseInt(command);

            if (num < minNum){
                minNum = num;
            }
            command = scanner.nextLine();
        }
        System.out.println(minNum);
    }
}
