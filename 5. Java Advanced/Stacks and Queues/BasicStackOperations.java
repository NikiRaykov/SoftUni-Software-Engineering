import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> myStack = new ArrayDeque<>();

        int elementsToPush = Integer.parseInt(input[0]);
        int elementsToPop = Integer.parseInt(input[1]);
        int checkIfPresent = Integer.parseInt(input[2]);

        String[] numbers = scanner.nextLine().split("\\s+");

        for (int i = 0; i < elementsToPush; i++) {
            int number = Integer.parseInt(numbers[i]);
            myStack.push(number);
        }

        for (int i = 0; i < elementsToPop; i++) {
            if (myStack.size() == 0){
                System.out.println(0);
                return;
            }
            myStack.pop();
        }


        if (myStack.contains(checkIfPresent)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(myStack));
        }
        }
    }

