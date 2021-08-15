import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // First IN first OUT
        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> myStack = new ArrayDeque<>();

        int elementsToOffer = Integer.parseInt(input[0]);
        int elementsToPoll = Integer.parseInt(input[1]);
        int checkIfPresent = Integer.parseInt(input[2]);

        String[] numbers = scanner.nextLine().split("\\s+");

        for (int i = 0; i < elementsToOffer; i++) {
            int number = Integer.parseInt(numbers[i]);
            myStack.offer(number);
        }

        for (int i = 0; i < elementsToPoll; i++) {
            myStack.poll();
            if (myStack.size() == 0){
                System.out.println(0);
                return;
            }
        }


        if (myStack.contains(checkIfPresent)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(myStack));
        }
    }
}
