import java.util.Arrays;
import java.util.Scanner;


// Write a program, which prints all unique pairs in an array of integers whose sum is equal to a given number.
public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        int magicNumber = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j <= numbers.length - 1; j++) {
                if (numbers[i] + numbers[j] == magicNumber){
                    counter ++;
                    if (counter > 1){
                        System.out.println();
                    }
                    System.out.print(numbers[i] + " " + numbers[j]);
                }
                }
            }
        }
    }

