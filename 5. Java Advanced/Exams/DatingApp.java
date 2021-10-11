import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Stack
        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(males::push);

        // Queue
        ArrayDeque<Integer> females = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int matches = 0;

        while (!females.isEmpty() && !males.isEmpty()){
            int firstFemale = females.peek();
            int lastMale = males.peek();

            if (firstFemale <= 0){
                females.poll();
                continue;
            }else if (lastMale <= 0){
                males.pop();
                continue;
            }else if (firstFemale % 25 == 0){
                for (int i = 0; i < 2; i++) {
                    females.poll();
                }
                continue;
            }else if (lastMale % 25 == 0){
                for (int i = 0; i < 2; i++) {
                    males.pop();
                }
                continue;
            }



            if (firstFemale == lastMale){
                matches++;
                females.poll();
                males.pop();
            }else {
                females.poll();
                males.pop();
                males.push(lastMale - 2);
            }
        }

        System.out.println("Matches: " + matches);

        if (males.isEmpty()){
            System.out.println("Males left: none");
        }else {
            String outputMales = males.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Males left: " + outputMales);
        }

        if (females.isEmpty()){
            System.out.println("Females left: none");
        }else {
            String outputFemales = females.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Females left: " + outputFemales);
        }
    }
}
