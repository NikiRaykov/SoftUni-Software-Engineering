import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int cakeSize = width * length;

        String command = scanner.nextLine();

        while (!command.equals("STOP")){
            int piece = Integer.parseInt(command);
                cakeSize -= piece;

             if (cakeSize <= 0){
                 break;
             }

            command = scanner.nextLine();
        }

        if (cakeSize <= 0){
            System.out.printf("%d pieces are left!", cakeSize);
        }else {
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(cakeSize));
        }
    }
}
