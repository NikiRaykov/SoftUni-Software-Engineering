import java.util.Scanner;

public class ReverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");

        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            String temp = array[start];

            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }

        for (String str: array) {
            System.out.print(str + " ");
        }
    }
}
