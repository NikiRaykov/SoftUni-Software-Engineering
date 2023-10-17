import java.util.*;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstMagicBoxInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] secondMagicBoxInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> firstMagicBox = new ArrayDeque<>();

        for (int s : firstMagicBoxInput) {
            firstMagicBox.offer(s);
        }

        ArrayDeque<Integer> secondMagicBox = new ArrayDeque<>();

        for (int s : secondMagicBoxInput) {
            secondMagicBox.push(s);
        }

        List<Integer> collectedItems = new ArrayList<>();

        for (int i = 0; i < firstMagicBox.size(); i++) {
            for (int j = 0; j < secondMagicBox.size(); j++) {
                int firstEl = firstMagicBox.peek();
                int lastEl = secondMagicBox.peek();
                int sum = firstEl + lastEl;

                if (sum % 2 == 0){
                    collectedItems.add(sum);
                    firstMagicBox.remove();
                    secondMagicBox.pop();
                }else {
                    secondMagicBox.pop();
                    firstMagicBox.offer(firstEl);
                }

                if (firstMagicBox.isEmpty()){
                    System.out.println("First magic box is empty.");
                    break;
                }else if (secondMagicBox.isEmpty()){
                    System.out.println("Second magic box is empty.");
                    break;
                }
                j--;
            }
        }

        Integer sumOfClaimedItems = collectedItems.stream().mapToInt(Integer::intValue).sum();

        if (sumOfClaimedItems >= 90){
            System.out.printf("Wow, your prey was epic! Value: %d", sumOfClaimedItems);
        }else {
            System.out.printf("Poor prey... Value: %d", sumOfClaimedItems);
        }
    }
}
