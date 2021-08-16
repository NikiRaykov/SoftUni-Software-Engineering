import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        // Last IN first OUT
        ArrayDeque<Character> myStack = new ArrayDeque<>();

        boolean isBalanced = true;

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            if(current =='{' || current == '[' || current == '('){
                myStack.push(current);
            }else {
                if (!myStack.isEmpty()){
                    if (current == ')') {
                        if (myStack.pop() != '(') {
                            isBalanced = false;
                        }
                    } else if (current == ']') {
                        if (myStack.pop() != '[') {
                            isBalanced = false;
                        }
                    } else if (current == '}') {
                        if (myStack.pop() != '{') {
                            isBalanced = false;
                        }
                    }
                }else {
                    isBalanced=false;
                }
                if(!isBalanced){
                    System.out.println("NO");
                    return;
                }
            }
            }
            System.out.println("YES");
    }
}
