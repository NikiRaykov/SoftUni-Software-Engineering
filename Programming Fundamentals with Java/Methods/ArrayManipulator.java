import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] numbersAsArray = scanner.nextLine().split(" ");
        int[] numbers = new int[numbersAsArray.length];

        for (int i = 0; i < numbersAsArray.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsArray[i]);
        }

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            if (command.contains("exchange")) {
                if (command.matches("[a-zA-Z ]*\\d+.*")) {
                    String numberOnly = command.replaceAll("[^0-9]", "");
                    int numberCommand = Integer.parseInt(numberOnly);
                    if (numberCommand > numbers.length) {
                        System.out.println("Invalid index");
                        break;
                    }
                    for (int i = 0; i < numberCommand; i++) {
                        int firstElement = numbers[0];

                        // We shift every element to the left
                        for (int j = 0; j < numbers.length - 1; j++) {
                            numbers[j] = numbers[j + 1];
                        }
                        numbers[numbers.length - 1] = firstElement;
                    }

                    for (int i = 0; i < numbers.length; i++) {
                        System.out.print(numbers[i] + " ");
                    }
                } else if (command.equals("max even")) {
                    int maxOdd, minOdd, maxEven, minEven;
                    Arrays.sort(numbers);
                    System.out.println("Minimum = " + numbers[0]);
                    System.out.println("Maximum = " + numbers[numbers.length - 1]);

                }
                command = scanner.nextLine();
            }
        }
    }
}
