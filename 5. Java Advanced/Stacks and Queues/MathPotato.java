import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> players = Arrays.stream(scanner.nextLine().split(" ")).
                map(String::new).collect(Collectors.toCollection(ArrayDeque::new));

        int n = Integer.parseInt(scanner.nextLine());


        int cycle = 1;
        while (players.size() > 1){
            IntStream.range(1, n).forEach(i -> players.offer(Objects.requireNonNull(players.poll())));
            if (isPrime(cycle)){
                System.out.println("Prime " + players.peek());
            } else {
                System.out.println("Removed " + players.poll());
            }
            cycle++;
            }
        System.out.println("Last is " + players.poll());
        }
    private static boolean isPrime (int cycle) {
        if (cycle == 1) {
            return false;
        }
        for (int i = 2; i <= cycle / 2; i++) {
            if (cycle % i == 0) {
                return false;
            }
        }
        return true;
    }
        }



