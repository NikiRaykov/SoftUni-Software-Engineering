import java.util.*;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split( "\\|");

        List<String> treasureChest = new ArrayList<>(Arrays.asList(input));
        String commands = scanner.nextLine();

        while (!commands.equals("Yohoho!")){
            String[] tokens = commands.split(" ");
            String currentCommand = tokens[0];
            switch (currentCommand){
                case "Loot":
                    for (int i = 1; i < tokens.length; i++) {
                        if (!treasureChest.contains(tokens[i])){
                            treasureChest.add(0, tokens[i]);
                        }
                    }
                    break;
                case "Drop":
                    int indexOfTheItemToBeDropped = Integer.parseInt(tokens[1]);
                    if (indexOfTheItemToBeDropped < 0 || indexOfTheItemToBeDropped >= treasureChest.size()){
                        break;
                    }

                    String itemToDrop = treasureChest.remove(indexOfTheItemToBeDropped);
                    treasureChest.add(itemToDrop);
                    break;
                case "Steal":
                    int stealAmount = Integer.parseInt(tokens[1]);
                    List<String> stolenItems = new ArrayList<>();
                    String output = "";
                    if (stealAmount >= treasureChest.size()){
                        output = String.join(", ", treasureChest);
                        System.out.println(output);
                        treasureChest.clear();
                    }else {
                        for (int i = 0; i < stealAmount; i++) {
                            int lastIndex = treasureChest.size() - 1;
                            stolenItems.add(0, treasureChest.remove(lastIndex));
                        }
                        output = String.join(", ", stolenItems);
                        System.out.println(output);
                    }
                    break;
                    }
            commands = scanner.nextLine();
            }
        double sum = 0;
        double count = treasureChest.size();
        double average = 0.0;
        for (String s: treasureChest){
            sum += s.length();
        }
        average = sum / count;
        if (sum == 0){
            System.out.println("Failed treasure hunt.");
        }else {
            System.out.printf("Average treasure gain: %.2f pirate credits.", average);
        }
        }
    }

