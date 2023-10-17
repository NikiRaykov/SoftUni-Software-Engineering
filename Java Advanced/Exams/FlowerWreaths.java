import java.util.*;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] roses = readRoses(scanner);

        int[] lilies = readLilies(scanner);

        ArrayDeque<Integer> rosesFlower = new ArrayDeque<>();
        fillTulipsStack(roses, rosesFlower);

        ArrayDeque<Integer> liliesFlower = new ArrayDeque<>();
        fillDaffodilsQueue(lilies, liliesFlower);

        List<Integer> lessThan15 = new ArrayList<>();

        int wreaths = 0;

        for (int i = 0; i < rosesFlower.size(); i++) {
            for (int j = 0; j < liliesFlower.size(); j++) {
                if (!rosesFlower.isEmpty() && !liliesFlower.isEmpty()){
                    int lastTulip = rosesFlower.peek();
                    int firstDaffodil = liliesFlower.peek();
                    int sum = lastTulip + firstDaffodil;

                    if (sum == 15){
                        wreaths++;
                        rosesFlower.pop();
                        liliesFlower.remove();
                    }else if (sum > 15){
                        while (sum > 15){
                            if (!rosesFlower.isEmpty()){
                                lastTulip = rosesFlower.peek();
                                rosesFlower.pop();
                                rosesFlower.push(lastTulip - 2);
                            }

                            if (!rosesFlower.isEmpty()){
                                sum = rosesFlower.peek() + firstDaffodil;
                            }

                            if (sum == 15) {
                                wreaths++;
                                rosesFlower.pop();
                                liliesFlower.remove();
                                sum = 0;
                            }else if (sum < 15){
                                lessThan15.add(sum);
                                rosesFlower.pop();
                                liliesFlower.remove();
                            }
                        }
                    }else {
                        lessThan15.add(sum);
                        rosesFlower.pop();
                        liliesFlower.remove();
                    }
                    j--;
                }
            }
        }

        int newSum = 0;
        for (Integer less: lessThan15){
            if (lessThan15.size() == 1){
                if (less < 15){
                    break;
                }else if (less == 15){
                    wreaths++;
                }
            }else {
                newSum += less;
            }
        }

        int newBouquets = newSum / 15;
        wreaths += newBouquets;

        if (wreaths >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreaths);
        }else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }
    }

    private static int[] readLilies(Scanner scanner) {
        int[] daffodils  = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        return daffodils;
    }

    private static int[] readRoses(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static void fillDaffodilsQueue(int[] daffodils, ArrayDeque<Integer> daffodilsFlowers) {
        for (Integer daffodil: daffodils){
            daffodilsFlowers.offer(daffodil);
        }
    }

    private static void fillTulipsStack(int[] tulips, ArrayDeque<Integer> tulipsFlowers) {
        for (Integer tulip: tulips){
            tulipsFlowers.push(tulip);
        }
    }
}
