import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");
        int rotations = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[line.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        for (int i = 0; i < rotations; i++) {
            int firstElement = numbers[0];
            // shift elements to the left
            for (int j = 0; j < numbers.length - 1; j++) {
                numbers[j] = numbers[j + 1];
            }
            // add first element to last position
            numbers[numbers.length - 1] = firstElement;
        }

        for (int x: numbers){
            System.out.print(x + " ");
        }
    }
}

