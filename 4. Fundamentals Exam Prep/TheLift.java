import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleWaiting = Integer.parseInt(scanner.nextLine());

        if (peopleWaiting <= 0){
            return;
        }

        int maxCapacity = 4;

        List<Integer> lift = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());


        for (int i = 0; i < lift.size(); i++) {

            if (lift.get(i) > 0){
                int oldValue = lift.get(i);
                int peopleWhoGotInside = maxCapacity - oldValue;
                lift.set(i, lift.get(i) + peopleWhoGotInside);
                peopleWaiting -= peopleWhoGotInside;
            }else {
                lift.set(i, Math.min(peopleWaiting, maxCapacity));
                peopleWaiting -= maxCapacity;
            }

            if (peopleWaiting <= 0){
                break;
            }


        }

        for (int i = 0; i < lift.size(); i++) {
            if (lift.get(i) < 4){
                System.out.println("The lift has empty spots!");
                break;
            }
        }

        if (peopleWaiting > 0){
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
        }

        for (Integer n: lift){
            System.out.print(n + " ");
        }
    }
}
