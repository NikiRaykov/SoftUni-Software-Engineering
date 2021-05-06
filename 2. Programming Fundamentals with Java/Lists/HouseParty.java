import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = new ArrayList<>();
        int numberOfCommand = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommand; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];

            if (tokens.length == 3){
                if (names.contains(name)){
                    System.out.printf("%s is already in the list!%n", name);
                }else {
                    names.add(name);
                }
            }else {
                   if (!names.remove(name)){
                       System.out.println(name + " is not in the list!");
                   }
            }
        }
        for (String people: names){
            System.out.println(people);
        }
    }
}
