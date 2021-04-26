import java.util.Scanner;

public class CinemaVoucher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int voucherValue = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int price = 0; int ticketCounter = 0; int otherProducts = 0;

        while (!command.equals("End")){
            if (command.length() > 8){
              price = command.charAt(0) + command.charAt(1);
              voucherValue -= price;
                if (voucherValue <= 0){
                    break;
                }
              ticketCounter++;
            }else {
                price = command.charAt(0);
                voucherValue -= price;
                if (voucherValue <= 0){
                    break;
                }
                otherProducts++;
            }

            command = scanner.nextLine();
        }
        System.out.println(ticketCounter);
        System.out.println(otherProducts);
    }
}
