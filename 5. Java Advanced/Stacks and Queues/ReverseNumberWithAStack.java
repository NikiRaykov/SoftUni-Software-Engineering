import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumberWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (String d: input) {
            numbers.push(Integer.parseInt(d));
        }

        while (!numbers.isEmpty()){
            System.out.print(numbers.pop() + " ");
        }
    }
}
