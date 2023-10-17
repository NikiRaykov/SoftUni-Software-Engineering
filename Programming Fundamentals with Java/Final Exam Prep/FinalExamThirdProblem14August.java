import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FinalExamThirdProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, int[]> people = new HashMap<String, int[]>();

        String input = scanner.nextLine();

        while (!input.equals("Results")){
            String[] tokens = input.split(":");
            String command = tokens[0];

            switch (command){
                case "Add":
                    String personName = tokens[1];
                    int health = Integer.parseInt(tokens[2]);
                    int energy = Integer.parseInt(tokens[3]);

                    if (people.containsKey(personName)){
                        int oldValue = people.get(personName)[0];
                        people.put(personName, new int[] {oldValue + health, people.get(personName)[1]});
                    }else {
                        people.put(personName, new int[] {health, energy});
                    }
                    break;
                case "Attack":
                    String attackerName = tokens[1];
                    String defenderName = tokens[2];
                    int damage = Integer.parseInt(tokens[3]);

                    if (people.containsKey(attackerName) && people.containsKey(defenderName)){
                        int defenderOldHealth = people.get(defenderName)[0];
                        int defenderNewHealth = defenderOldHealth - damage;

                        int attackerOldEnergy = people.get(attackerName)[1];
                        int newAttackerEnergy  = --attackerOldEnergy;

                        if (defenderNewHealth <= 0){
                            people.remove(defenderName);
                            System.out.printf("%s was disqualified!%n", defenderName);
                        }else {
                            people.put(defenderName, new int[] {defenderNewHealth, people.get(defenderName)[1]});
                        }

                        if (newAttackerEnergy <= 0){
                            people.remove(attackerName);
                            System.out.printf("%s was disqualified!%n", attackerName);
                        }else {
                            people.put(attackerName, new int[] {people.get(attackerName)[0], newAttackerEnergy});
                        }
                    }
                    break;
                case "Delete":
                    String username = tokens[1];

                    if (username.equals("All")){
                        people.clear();
                    }else {
                        people.remove(username);
                    }

                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println("People count: " + people.size());
        HashMap<String, int[]> result = people.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((int[] a, int[] b) ->
                        IntStream.of(b).sum() - IntStream.of(a).sum())
                )
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        result.forEach((key, value) -> System.out.println(key + " - " + value[0] + " - " + value[1]));
    }
}
