import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materials = new TreeMap<>() {{
            put("shards", 0);
            put("fragments", 0);
            put("motes", 0);
        }};
        Map<String, Integer> junk = new TreeMap<>();

        boolean isFound = false;

        while (!isFound){
            String[] input = scanner.nextLine().split("\\s+");
            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")){
                    if (!materials.containsKey(material)){
                        materials.put(material, quantity);
                    }else  if (materials.containsKey(material)){
                        int counter = materials.get(material);
                        counter += quantity;
                        if (counter >= 250){
                            materials.put(material, counter - 250);
                            if (material.equals("shards")){
                                System.out.println("Shadowmourne obtained!");
                            }else if (material.equals("fragments")){
                                System.out.println("Valanyr obtained!");
                            }else if (material.equals("motes")){
                                System.out.println("Dragonwrath obtained!");
                            }
                            isFound = true;
                            break;
                        }else {
                            materials.put(material, counter);
                        }
                    }else if (quantity >= 250){
                        if (material.equals("shards")){
                            System.out.println("Shadowmourne obtained!");
                        }else if (material.equals("fragments")){
                            System.out.println("Valanyr obtained!");
                        }else if (material.equals("motes")){
                            System.out.println("Dragonwrath  obtained!");
                        }
                        isFound = true;
                        materials.put(material, quantity - 250);
                        break;
                    }
                }else {
                    if (!junk.containsKey(material)){
                        junk.put(material, quantity);
                    }else {
                        int count = junk.get(material);
                        count++;
                        junk.put(material, count);
                    }
                }
            }
        }
        materials.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        junk.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
