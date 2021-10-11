import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int doll = 150; int woodenTrain = 250; int teddyBear = 300; int bicycle = 400;
        int dollCount = 0; int woodenTrainCount = 0; int teddyBearCount = 0; int bicycleCount = 0;
        // Stack
        ArrayDeque<Integer> materials = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(materials::push);

        // Queue
        ArrayDeque<Integer> magicLevels = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));


        while (!magicLevels.isEmpty() && !materials.isEmpty()){
            int result = 0;
            int lastBoxWithMaterials = materials.peek();
            int firstMagicLevel = magicLevels.peek();


            if (lastBoxWithMaterials == 0 && firstMagicLevel == 0){
                materials.pop();
                magicLevels.poll();
                continue;
            } else if (lastBoxWithMaterials == 0){
                materials.pop();
                continue;
            } else if(firstMagicLevel == 0){
                magicLevels.poll();
                continue;
            }

            result = lastBoxWithMaterials * firstMagicLevel;
            if (result == doll){
                dollCount++;
                materials.pop();
                magicLevels.poll();
            }else if (result == woodenTrain){
                woodenTrainCount++;
                materials.pop();
                magicLevels.poll();
            }else if (result == teddyBear){
                teddyBearCount++;
                materials.pop();
                magicLevels.poll();
            }else if (result == bicycle){
                bicycleCount++;
                materials.pop();
                magicLevels.poll();
            }else if (result < 0){
                int sum = lastBoxWithMaterials + firstMagicLevel;
                materials.pop();
                magicLevels.poll();
                materials.push(sum);
            }else {
                magicLevels.poll();
                materials.pop();
                materials.push(lastBoxWithMaterials + 15);
            }
        }

        if (dollCount > 0 && woodenTrainCount > 0 || teddyBearCount > 0 && bicycleCount > 0){
            System.out.println("The presents are crafted! Merry Christmas!");
        }else {
            System.out.println("No presents this Christmas!");
        }

        if (!materials.isEmpty()){
            String outputMaterials = materials.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Materials left: " + outputMaterials);
        }
        if (!magicLevels.isEmpty()){
            String outputMagic = magicLevels.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Magic left: " + outputMagic);
        }

        if (bicycleCount > 0){
            System.out.println("Bicycle: " + bicycleCount);
        }
        if (dollCount > 0){
            System.out.println("Doll: " + dollCount);
        }
        if (teddyBearCount > 0){
            System.out.println("Teddy bear: " + teddyBearCount);
        }

        if (woodenTrainCount > 0){
            System.out.println("Wooden train: " + woodenTrainCount);
        }
    }
}
