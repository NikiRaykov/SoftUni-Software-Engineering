import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> ids = new ArrayList<>();

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");

            ids.add(tokens.length == 3
                    ? new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2])
                    : new Robot(tokens[0], tokens[1]));

            command = scanner.nextLine();
        }

        String fakeIdNums = scanner.nextLine();

        for (Identifiable id : ids) {
            System.out.printf("%s", id.getId().endsWith(fakeIdNums) ? id.getId() + System.lineSeparator() : "");
        }
    }
}
