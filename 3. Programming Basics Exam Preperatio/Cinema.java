import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int movieTheatreCapacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        boolean isFull = false; int ticketPrice = 5; int profit = 0;

        while (!command.equals("Movie time!")){
            int peopleComingIn = Integer.parseInt(command);

            if (peopleComingIn > movieTheatreCapacity){
                isFull = true;
                break;
            }

            if (peopleComingIn % 3 == 0){
                profit += (peopleComingIn * ticketPrice) - 5;
            }else {
                profit += peopleComingIn * ticketPrice;
            }
            movieTheatreCapacity -= peopleComingIn;

            command = scanner.nextLine();
        }
        if (isFull){
            System.out.println("The cinema is full.");
        }else {
            System.out.printf("There are %d seats left in the cinema.\n", movieTheatreCapacity);
        }
        System.out.printf("Cinema income - %d lv.", profit);
    }
}