import java.util.*;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfOperations = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> myTextHistory = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < numberOfOperations; i++) {
            String input = scanner.nextLine();
            String[] operations = input.split("\\s+");
            String operation = operations[0];

            switch (operation){
                case "1":
                    String textToAppend = operations[1];
                    myTextHistory.push(text.toString());
                    text.append(textToAppend);
                    break;
                case "2":
                    myTextHistory.push(text.toString());
                    int countToErase = Integer.parseInt(operations[1]);
                    int start = text.length() - countToErase;
                    text.delete(start, start + countToErase);
                    break;
                case "3":
                    int index = Integer.parseInt(operations[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    if (!myTextHistory.isEmpty()){
                       text = new StringBuilder(myTextHistory.pop());
                    }
                    break;
            }

        }
    }
}
