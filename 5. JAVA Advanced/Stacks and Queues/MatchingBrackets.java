import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        ArrayDeque<Integer> myStack = new ArrayDeque<>();

        for (int index = 0; index < expression.length(); index++) {
            char ch = expression.charAt(index);

            if (ch == '('){
                myStack.push(index);
            }else if (ch == ')'){
                int startIndex = myStack.pop();
                String contents = expression.substring(startIndex, index + 1);
                System.out.println(contents);
            }
        }
    }
}

