import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// You will be given two hands of cards, which will be integer numbers. Assume that you have two players. You have to find out the winning deck and respectively the winner.
//You start from the beginning of both hands.
// Compare the cards from the first deck to the cards from the second deck.
// The player, who has bigger card, takes both cards and puts them at the back of his hand -
// the second player's card is last, and the first person's card (the winning one) is before it (second to last) and the player with
// smaller card must remove the card from his deck. If both players' cards have the same values - no one wins,
// and the two cards must be removed from the decks. The game is over when one of the decks is left without any cards.
// You have to print the winner on the console and the sum of the left cards: "Player {one/two} wins! Sum: {sum}".

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());

        while (!(firstPlayer.isEmpty() || secondPlayer.isEmpty())){
            int first = firstPlayer.get(0);
            int second = secondPlayer.get(0);
            if (first == second){
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            }else if (first > second){
                firstPlayer.add(first);
                firstPlayer.add(second);
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            }else {
                secondPlayer.add(second);
                secondPlayer.add(first);
                secondPlayer.remove(0);
                firstPlayer.remove(0);
            }
        }
        int sum = 0;
        if (!firstPlayer.isEmpty()){
            for (Integer integer : firstPlayer) {
                sum += integer;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        }else {
            for (Integer integer : secondPlayer) {
                sum += integer;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }
    }
}
