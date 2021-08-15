import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> players = Arrays.stream(scanner.nextLine().split(" ")).
                map(String::new).collect(Collectors.toCollection(ArrayDeque::new));

        int n = Integer.parseInt(scanner.nextLine());

        while (players.size() > 1){
                IntStream.range(1, n).forEach(i -> players.offer(Objects.requireNonNull(players.poll())));
                System.out.println("Removed " + players.poll());
        }
        System.out.println("Last is " + players.poll());
    }
}
