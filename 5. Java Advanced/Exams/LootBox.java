import java.util.*;
import java.util.stream.Collectors;

public class LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       // Queue
        ArrayDeque<Integer> firstBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        // Stack
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
                Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBox::push);

         List<Integer> claimedItems = new ArrayList<>();

         while (!firstBox.isEmpty() && !secondBox.isEmpty()){
             int firstEl = firstBox.peek();
             int lastEl = secondBox.peek();

             int sum = firstEl + lastEl;

             if (sum % 2 == 0){
                 claimedItems.add(sum);
                 firstBox.poll();
             }else {
                 firstBox.offer(firstEl);
             }
             secondBox.pop();
         }

         if (firstBox.isEmpty()){
             System.out.println("First lootbox is empty");
         }else {
             System.out.println("Second lootbox is empty");
         }

        int itemValue = claimedItems.stream().mapToInt(Integer::intValue).sum();

         if (itemValue >= 100){
             System.out.println("Your loot was epic! Value: " + itemValue);
         }else {
             System.out.println("Your loot was poor... Value: " + itemValue);
         }
    }
}
