import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// Write a program to calculate the winner of a car race. You will receive an array of numbers.
// Each element of the array represents the time needed to pass through that step (the index).
// There are going to be two cars. One of them starts from the left side and the other one starts from the right side.
// The middle index of the array is the finish line. (The number of elements of the array will always be odd).
// Calculate the total time for each racer to reach the finish (the middle of the array) and print the winner with his total time.
// (The racer with less time). If you have a zero in the array, you have to reduce the time of the racer that reached it by 20%
// (from the time so far).
//Print the result in the following format "The winner is {left/right} with total time: {total time}",
// formatted with one digit after the decimal point.

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // list input
        List<Integer> numbersAsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        // we find the middle element in the list
        int finishLine = numbersAsList.size()/2;

        // we create a list for the right racer
        List<Integer> rightRacer = new ArrayList<>();
        for (int i = numbersAsList.size() - 1; i > finishLine; i--) {
            rightRacer.add(numbersAsList.get(i));
        }

        // we calculate the time of the right racer
        double timeRightRacer = 0;
        for (int value: rightRacer){
            if (value == 0){
                timeRightRacer *= 0.8;
            }
            timeRightRacer += value;
        }

        // we create a list for the left racer
        List<Integer> leftRacer = new ArrayList<>();
        for (int i = 0; i < finishLine; i++) {
            leftRacer.add(numbersAsList.get(i));
        }

        // we calculate the time of the left racer
        double timeLeftRacer = 0;
        for (int n: leftRacer){
            if (n == 0){
                timeLeftRacer *= 0.8;
            }
            timeLeftRacer += n;
        }
        if (timeLeftRacer < timeRightRacer){
            System.out.printf("The winner is left with total time: %.1f", timeLeftRacer);
        }else {
            System.out.printf("The winner is right with total time: %.1f", timeRightRacer);
        }
    }
}
