import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        List<String> inventory = new ArrayList<>(Arrays.asList(input));
        String commands = scanner.nextLine();

        while (!commands.equals("Craft!")){
            String[] tokens = commands.split(" - ");
            switch (tokens[0]){
                case "Collect":
                    if (!inventory.contains(tokens[1])){
                        inventory.add(tokens[1]);
                    }
                    break;
                case "Drop":
                    if (inventory.contains(tokens[1])){
                        inventory.remove(tokens[1]);
                    }
                    break;
                case "Combine Items":
                   String[] items = tokens[1].split(":");
                    if (inventory.contains(items[0])){
                        inventory.add(inventory.indexOf(items[0]) + 1, items[1]);
                    }
                    break;
                case "Renew":
                    String item = tokens[1];
                    if (inventory.contains(item)){
                        inventory.remove(item);
                        inventory.add(item);
                    }

                    break;
            }
            commands = scanner.nextLine();
        }
        boolean isFirst = true;
        for (String x: inventory){
            if (isFirst) {
                System.out.print(x);
                isFirst = false;
        }else {
                System.out.print(", " + x);
            }
        }
        }
    }

