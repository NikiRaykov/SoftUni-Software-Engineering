import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// Write a program that reads sequence of numbers and special bomb number with a certain power.
// Your task is to detonate every occurrence of the special bomb number and according to its power -
// his neighbors from left and right. Detonations are performed from left to right and all detonated numbers disappear.
// Finally print the sum of the remaining elements in the sequence.

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> bombInfo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int bombNumber = bombInfo.get(0);
        int powerNumber = bombInfo.get(1);

       while (numbers.contains(bombNumber)){
            int bombPosition = numbers.indexOf(bombNumber);

            int leftBound = Math.max(0, bombPosition - powerNumber);
            int rightBound = Math.min(numbers.size() - 1, bombPosition + powerNumber);

           for (int i = rightBound; i >= leftBound; i--) {
               numbers.remove(i);
           }
       }
       int sum = 0;
        for (Integer specialNumber : numbers) {
            sum += specialNumber;
        }
        System.out.println(sum);
    }
}
