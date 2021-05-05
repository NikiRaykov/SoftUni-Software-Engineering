import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> train = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("end")){
            String[] tokens = command.split(" ");

            if (tokens[0].equals("Add")){
                    int numberToAdd = Integer.parseInt(tokens[1]);
                    train.add(numberToAdd);
            }else {
                    int numberToAdd = Integer.parseInt(tokens[0]);
                for (int i = 0; i < train.size(); i++) {
                    if (train.get(i) + numberToAdd <= maxCapacity){
                        train.set(i, train.get(i) + numberToAdd);
                        break;
                    }
                }
            }

            command = scanner.nextLine();
        }
        for (int i = 0; i < train.size(); i++) {
            System.out.print(train.get(i) + " ");
        }
    }
}
