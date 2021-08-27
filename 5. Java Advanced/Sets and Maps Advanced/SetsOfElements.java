import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> firstSet = IntStream.range(0, size[0]).mapToObj(i -> Integer.parseInt(scanner.nextLine()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondSet = IntStream.range(0, size[1]).mapToObj(i -> Integer.parseInt(scanner.nextLine()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        firstSet.stream().filter(secondSet::contains).map(equals -> equals + " ").forEach(System.out::print);
    }
}
