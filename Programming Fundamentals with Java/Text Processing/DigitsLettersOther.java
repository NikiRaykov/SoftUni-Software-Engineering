import java.util.Scanner;

public class DigitsLettersOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        char[] myArray = input.toCharArray();

        StringBuilder numbers = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder somethingElse = new StringBuilder();

        for (int i = 0; i < myArray.length; i++) {
            if (Character.isDigit(myArray[i])){
                numbers.append(myArray[i]);
            }else if (Character.isLetter(myArray[i])){
                letters.append(myArray[i]);
            }else {
                somethingElse.append(myArray[i]);
            }
        }
        System.out.println(numbers);
        System.out.println(letters);
        System.out.println(somethingElse);
    }
}
