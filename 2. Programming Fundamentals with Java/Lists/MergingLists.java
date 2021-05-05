import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstListOfNumbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondListOfNumbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());


        // we make a result list
        List<Integer> resultList = new ArrayList<>();
        int firstListIndex = 0;
        int secondListIndex = 0;

        while (firstListIndex < firstListOfNumbers.size() || secondListIndex < secondListOfNumbers.size()){
            if (firstListIndex < firstListOfNumbers.size()){
                resultList.add(firstListOfNumbers.get(firstListIndex));
            }

            if (secondListIndex < secondListOfNumbers.size()){
                resultList.add(secondListOfNumbers.get(secondListIndex));
            }

            firstListIndex++;
            secondListIndex++;
        }

        for (int n: resultList){
            System.out.print(n + " ");
        }
    }
}
