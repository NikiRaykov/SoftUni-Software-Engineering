import java.util.*;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tulips = readTulips(scanner);

        int[] daffodils = readDaffodils(scanner);

        ArrayDeque<Integer> tulipsFlowers = new ArrayDeque<>();
        fillTulipsStack(tulips, tulipsFlowers);

        ArrayDeque<Integer> daffodilsFlowers = new ArrayDeque<>();
        fillDaffodilsQueue(daffodils, daffodilsFlowers);

        List<Integer> lessThan15 = new ArrayList<>();

        int bouquet = 0;

        for (int i = 0; i < tulipsFlowers.size(); i++) {
            for (int j = 0; j < daffodilsFlowers.size(); j++) {
                if (!tulipsFlowers.isEmpty() && !daffodilsFlowers.isEmpty()){
                    int lastTulip = tulipsFlowers.peek();
                    int firstDaffodil = daffodilsFlowers.peek();
                    int sum = lastTulip + firstDaffodil;

                    if (sum == 15){
                        bouquet++;
                        tulipsFlowers.pop();
                        daffodilsFlowers.remove();
                    }else if (sum > 15){
                        while (sum > 15){
                            if (!tulipsFlowers.isEmpty()){
                                lastTulip = tulipsFlowers.peek();
                                tulipsFlowers.pop();
                                tulipsFlowers.push(lastTulip - 2);
                            }

                            if (!tulipsFlowers.isEmpty()){
                                sum = tulipsFlowers.peek() + firstDaffodil;
                            }

                            if (sum == 15) {
                                bouquet++;
                                tulipsFlowers.pop();
                                daffodilsFlowers.remove();
                                sum = 0;
                            }else if (sum < 15){
                                lessThan15.add(sum);
                                tulipsFlowers.pop();
                                daffodilsFlowers.remove();
                            }
                        }
                    }else {
                        lessThan15.add(sum);
                        tulipsFlowers.pop();
                        daffodilsFlowers.remove();
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
                    bouquet++;
                }
            }else {
                newSum += less;
            }
        }

        int newBouquets = newSum / 15;
        bouquet += newBouquets;

        if (bouquet >= 5){
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", bouquet);
        }else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquet);
        }
    }

    private static int[] readDaffodils(Scanner scanner) {
        int[] daffodils  = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        return daffodils;
    }

    private static int[] readTulips(Scanner scanner) {
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
