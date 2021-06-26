import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        double averageNumber = 0; double sum = 0;

        for (Integer number : numbers) {
            sum += number;
        }
        averageNumber = sum / numbers.size();

        List<Integer> topNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > averageNumber){
                topNumbers.add(numbers.get(i));
            }
        }

        if (topNumbers.size() == 0){
            System.out.println("No");
            return;
        }

        Collections.sort(topNumbers);
        int counter = 0;
        for (int i = topNumbers.size() - 1; i >= 0; i--) {
            if (counter < 5){
                System.out.print(topNumbers.get(i) + " ");
                counter++;
            }
        }
        }
    }

