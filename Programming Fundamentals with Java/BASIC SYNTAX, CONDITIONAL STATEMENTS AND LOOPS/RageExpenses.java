import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int counter = 0; int trashedHeadset = 0; int trashedMouse = 0; int trashedKeyboard = 0; int trashedDisplay = 0;
        double rageExpenses = 0;

        for (int i = 1; i <= lostGames; i++) {
                counter ++;

                if (counter % 2 == 0){
                        trashedHeadset++;
                }

                    if (counter % 3 == 0){
                    trashedMouse++;
                }
                    if (counter % 2 == 0 && counter % 3 == 0){
                    trashedKeyboard++;
                    if (trashedKeyboard % 2 == 0){
                        trashedDisplay++;
                    }
                }
        }
        rageExpenses = ((trashedHeadset * headsetPrice) + (trashedMouse * mousePrice) + (trashedKeyboard * keyboardPrice) + (trashedDisplay * displayPrice));

        System.out.printf("Rage expenses: %.2f lv.", rageExpenses);
    }
}
