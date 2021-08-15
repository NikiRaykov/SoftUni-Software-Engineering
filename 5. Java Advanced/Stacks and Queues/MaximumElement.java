import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> myStackNumbers = new ArrayDeque<>();

        for (int i = 0; i < commands; i++) {
            String input = scanner.nextLine();
            if (input.length() > 1){
                String[] tokens = input.split("\\s+");
                int elementToPush = Integer.parseInt(tokens[1]);
                myStackNumbers.push(elementToPush);
            }else {
                if (input.equals("2")){
                    myStackNumbers.pop();
                }else if (input.equals("3")){
                    System.out.println(Collections.max(myStackNumbers));
                }
            }

        }
    }
}
