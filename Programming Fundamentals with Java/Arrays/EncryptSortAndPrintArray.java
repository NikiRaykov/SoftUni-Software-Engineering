import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfStrings = Integer.parseInt(scanner.nextLine());
        int vowel = 0; int consonants = 0;
        int[] numbers = new int[numberOfStrings];

        for (int i = 0; i < numberOfStrings; i++) {
            String word = scanner.nextLine();
            char[] symbols = word.toCharArray();

            for (int j = 0; j < symbols.length; j++) {
                char ch = symbols[j];
                int len = symbols.length;

                if (ch == 'a' || ch == 'e' || ch == 'i' ||
                        ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' ||
                ch == 'I' || ch == 'O' || ch == 'U'){
                    vowel += ch * len;
                }else {
                    consonants += ch / len;
                }
            }
            int number = consonants + vowel;
            numbers[i] = number;
            vowel = 0; consonants = 0;
        }
            Arrays.sort(numbers);
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
