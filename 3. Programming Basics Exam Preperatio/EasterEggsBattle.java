import java.util.Scanner;

public class EasterEggsBattle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int eggsFirstPlayer = Integer.parseInt(scanner.nextLine());
        int eggsSecondPlayer = Integer.parseInt(scanner.nextLine());

        boolean firstPlayer = false;
        boolean secondPlayer = false;
        boolean commandTyped = false;

        for (int i = 1; i < 2; i++) {
            String command = scanner.nextLine();
            while (!command.equals("End of battle")){
                if (command.equals("one")){
                    eggsSecondPlayer --;
                }else if (command.equals("two")){
                    eggsFirstPlayer--;
                }
                if (eggsFirstPlayer == 0){
                    firstPlayer = true; // he is out of eggs
                    break;
                }else if (eggsSecondPlayer == 0){
                    secondPlayer = true;
                    break;
                }

                command = scanner.nextLine();
            }

            if (command.equals("End of battle")){
                commandTyped = true;
                break;
            }
        }
        if (commandTyped){
            System.out.printf("Player one has %d eggs left.\n", eggsFirstPlayer);
            System.out.printf("Player two has %d eggs left.", eggsSecondPlayer);
        } else if (firstPlayer){
            System.out.printf("Player one is out of eggs. Player two has %d eggs left.", eggsSecondPlayer);
        }else if (secondPlayer){
            System.out.printf("Player two is out of eggs. Player one has %d eggs left.", eggsFirstPlayer);
        }
    }
}

