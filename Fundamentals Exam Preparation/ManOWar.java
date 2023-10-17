import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scanner.nextLine().split(">")).
                map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> warShip = Arrays.stream(scanner.nextLine().split(">")).
                map(Integer::parseInt).collect(Collectors.toList());

        int maxHealthOfASection = Integer.parseInt(scanner.nextLine());

        String commands = scanner.nextLine();

        while (!commands.equals("Retire")){
            String[] tokens = commands.split(" ");

            switch (tokens[0]){
                case "Fire":
                    int index = Integer.parseInt(tokens[1]);
                    int damage = Integer.parseInt(tokens[2]);

                    if (index <= warShip.size() && index >= 0){
                        warShip.set(index, warShip.get(index) - damage);
                        if (warShip.get(index) <= 0){
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    int damageDealt = Integer.parseInt(tokens[3]);

                    if (startIndex < 0 || startIndex >= pirateShip.size()){
                        break;
                    }

                    if (endIndex < 0 || endIndex >= pirateShip.size()){
                        break;
                    }

                    for (int i = startIndex; i <= endIndex; i++) {
                        int currentSection = pirateShip.get(i);
                        currentSection -= damageDealt;
                        if (currentSection <= 0){
                            System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            }else {
                                pirateShip.set(i, currentSection);
                        }
                        }
                    break;
                case "Repair":
                    int repairIndex = Integer.parseInt(tokens[1]);
                    int health = Integer.parseInt(tokens[2]);

                    if (repairIndex < 0 || repairIndex >= pirateShip.size()){
                        break;
                    }

                    int sectionToRepair = pirateShip.get(repairIndex);
                    sectionToRepair += health;

                    if (sectionToRepair > maxHealthOfASection){
                        sectionToRepair = maxHealthOfASection;
                    }
                        pirateShip.set(repairIndex, sectionToRepair);

                    break;
                case "Status":
                    double maxDiff = maxHealthOfASection * 0.2;
                    int counter = 0;
                    for (int i = 0; i < pirateShip.size(); i++) {
                        int checkIndex = pirateShip.get(i);
                        if (checkIndex < maxDiff){
                            counter++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", counter);
                    break;
            }

            commands = scanner.nextLine();
        }
        int sumOfPirateShip = 0; int sumOfWarShip = 0;
        for (Integer n: pirateShip){
            sumOfPirateShip += n;
        }
        System.out.println("Pirate ship status: " + sumOfPirateShip);

        for (Integer n: warShip){
            sumOfWarShip += n;
        }
        System.out.println("Warship status: " + sumOfWarShip);
    }
}
