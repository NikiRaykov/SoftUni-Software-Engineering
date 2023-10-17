import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int battlesWon = 0; boolean outOfEnergy = false;

        while (!command.equals("End of battle")){
            int distance = Integer.parseInt(command);

            if (distance > initialEnergy){
                outOfEnergy = true;
                break;
            }else if (distance != 0){
                initialEnergy -= distance;
                battlesWon++;
            }

            if (battlesWon % 3 == 0){
                initialEnergy += battlesWon;
            }
            command = scanner.nextLine();
        }
        if (outOfEnergy){
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", battlesWon, initialEnergy);
        }else {
            System.out.printf("Won battles: %d. Energy left: %d", battlesWon, initialEnergy);
        }
    }
}
