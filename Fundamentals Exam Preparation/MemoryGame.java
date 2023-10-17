import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        List<String> elements = new ArrayList<>();

        Collections.addAll(elements, input);

        String command = scanner.nextLine(); int moves = 0;

        while(!command.equals("end")){
            String[] indexes = command.split(" ");

            int firstIndex = Integer.parseInt(indexes[0]);
            int secondIndex = Integer.parseInt(indexes[1]);

            if (firstIndex == secondIndex || firstIndex < 0 || secondIndex < 0
                    || firstIndex >= elements.size() || secondIndex >= elements.size()){
                        System.out.println("Invalid input! Adding additional elements to the board");
                        moves++;
                        elements.add((elements.size() / 2), "-" + moves + "a");
                        elements.add(elements.size() / 2, "-" + moves + "a");
            }else {
                    if (elements.get(firstIndex).equals(elements.get(secondIndex))){
                        String element = elements.get(firstIndex);
                        elements.remove(firstIndex);
                        if (secondIndex != 0){
                            secondIndex--;
                        }
                        elements.remove(secondIndex);
                        moves++;
                        System.out.printf("Congrats! You have found matching elements - %s!%n", element);
                }else {
                        System.out.println("Try again!");
                    }
            }

            if (elements.size() == 0){
                System.out.printf("You have won in %d turns!", moves);
                return;
            }

            command = scanner.nextLine();
        }
        if (elements.size() != 0){
            System.out.println("Sorry you lose :(");
            for (String s: elements){
                System.out.print(s + " ");
            }
        }
    }
}
