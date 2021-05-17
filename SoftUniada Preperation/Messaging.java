import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// You will be given some list of numbers and a string.
// For each element of the list you have to take the sum of its digits and take the element corresponding to that index from the text.
// If the index is greater than the length of the text, start counting from the beginning (so that you always have a valid index).
// After getting the element from the text,
// you have to remove the character you have taken from it (so for the next index, the text will be with one character less).


public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // We read the list of integers
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        // We read the string input
        String input = scanner.nextLine();
        StringBuilder output = new StringBuilder(); // we create the final output
        char symbol;

        // we make a new list so that we can iterate through it
        List<Character> newList = new ArrayList<>();
        for (char character: input.toCharArray()){
            newList.add(character);
        }


        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> sumOfElement = new ArrayList<>();
            boolean isFound = false;
            // We take the first element of the List
            sumOfElement.add(numbers.get(i));
            // We sum its digits
            for (int j = 0; j < sumOfElement.size(); j++) {
                int sum = 0;
                int number = sumOfElement.get(j);
                int digit = 0;
                while (number > 0){
                    digit = number% 10;
                    sum += digit;
                    number = number / 10;
                }

                // We check if the sum is bigger than the size
                if (sum > newList.size()) {
                    symbol = input.charAt(sum - newList.size());
                    output.append(symbol);
                    // Once we append the symbol to the output, we remove it from the original List
                    for (int k = 0; k < newList.size(); k++) {
                        if (isFound){
                            break;
                        }
                        char letter = newList.get(k);
                        if (letter == symbol){
                            newList.remove(k);
                            isFound = true;
                            break;
                        }
                    }
                } else {
                    symbol = newList.get(sum);
                    output.append(symbol);
                    for (int k = 0; k < newList.size(); k++) {
                        if (isFound){
                            break;
                        }
                        char letter = newList.get(k);
                        if (letter == symbol){
                            newList.remove(k);
                            isFound = true;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(output);
    }
}
