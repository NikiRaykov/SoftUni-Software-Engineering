import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemOSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tasksToKill = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int[] threads = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int task = Integer.parseInt(scanner.nextLine());

        // Queue
        ArrayDeque<Integer> thread = new ArrayDeque<>();
        for (int j : threads) {
            thread.offer(j);
        }

        // Stack
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        for (int j : tasksToKill) {
            tasks.push(j);
        }

        boolean isFound = false;
        for (int i = 0; i < thread.size(); i++) {
            if (isFound){
                break;
            }
            for (int j = 0; j < tasks.size(); j++) {
                if (!thread.isEmpty() && !tasks.isEmpty()){
                    int firstGivenThreadValue = thread.peek();
                    int lastGivenTaskValue = tasks.peek();

                    if (lastGivenTaskValue == task){
                        System.out.printf("Thread with value %d killed task %d%n", firstGivenThreadValue, task);
                        tasks.pop();
                        isFound = true;
                        break;
                    }

                    thread.remove();
                    if (firstGivenThreadValue >= lastGivenTaskValue){
                        tasks.pop();
                    }
                }
                j--;
            }
        }
        for (Integer n: thread){
            System.out.print(n + " ");
        }
    }
}
