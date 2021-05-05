import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")){
            String[] tokens = command.split(" ");

            switch (tokens[0]){
                case "Delete":
                    int numberToDelete = Integer.parseInt(tokens[1]);
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) == numberToDelete){
                             numbers.remove(i);
                             --i;
                        }
                    }
                    break;
                case "Insert":
                    int elementToInsert = Integer.parseInt(tokens[1]);
                    int indexToInsertTheElement = Integer.parseInt(tokens[2]);
                    numbers.add(indexToInsertTheElement, elementToInsert);
                    break;
            }

            command = scanner.nextLine();
        }
        for (int n: numbers){
            System.out.print(n + " ");
        }
    }
}
