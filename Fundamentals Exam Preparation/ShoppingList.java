import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] list = scanner.nextLine().split("!");

        List<String> shoppingList = new ArrayList<>(Arrays.asList(list));
        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")){
            String[] tokens = command.split(" ");

            switch (tokens[0]){
                case "Urgent":
                    if (!shoppingList.contains(tokens[1])){
                        shoppingList.add(0, tokens[1]);
                    }
                    break;
                case "Unnecessary":
                       if (shoppingList.contains(tokens[1])){
                           shoppingList.remove(tokens[1]);
                       }
                    break;
                case "Correct":
                    if (shoppingList.contains(tokens[1])){
                        shoppingList.set(shoppingList.indexOf(tokens[1]), tokens[2]);
                    }
                    break;
                case "Rearrange":
                    if (shoppingList.contains(tokens[1])){
                        shoppingList.remove(tokens[1]);
                        shoppingList.add(tokens[1]);
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        boolean isFirst = true;
        for (String s : shoppingList) {
            if (isFirst) {
                System.out.print(s);        // no comma
                isFirst = false;
            } else {
                System.out.print(", "+s);   // comma
            }
        }
    }
}
