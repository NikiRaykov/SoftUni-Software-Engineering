import java.util.Random;
import java.util.Scanner;

// You are given a list of words on one line. Randomize their order and print each word on a separate line.

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        Random random = new Random();

        for (int i = 0; i < input.length; i++) {
            int randomIndex = random.nextInt(input.length);
            String temp = input[i];
            input[i] = input[randomIndex];
            input[randomIndex] = temp;
        }
        for (String word : input) {
            System.out.println(word);
        }
    }
}
