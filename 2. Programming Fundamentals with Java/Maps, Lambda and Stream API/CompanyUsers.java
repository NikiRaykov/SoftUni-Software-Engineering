import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> employees = new TreeMap<>();

        String command = scanner.nextLine();

        while (!command.equals("End")){
            String name = command.split(" -> ")[0];
            String id = command.split(" -> ")[1];

            employees.putIfAbsent(name, new ArrayList<>());
            if (!employees.get(name).contains(id)){
                employees.get(name).add(id);
            }

            command = scanner.nextLine();
        }
        employees.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(id -> System.out.printf("-- %s%n", id));
        });
    }
}
