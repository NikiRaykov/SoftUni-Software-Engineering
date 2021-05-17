import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("");

        List<String> encryptedMessage = new ArrayList<>(Arrays.asList(input));

        List<String> numbersList = new ArrayList<>();
        List<String> nonNumbersList = new ArrayList<>();
        for (int i = 0; i < encryptedMessage.size(); i++) {
            if (!encryptedMessage.get(i).matches("[0-9]")){
                nonNumbersList.add(encryptedMessage.get(i));
            }else {
                numbersList.add(encryptedMessage.get(i));
            }
        }

        // convert the StringNumberList into Integer List
        List<Integer> intNumberList = new ArrayList<>();
        for (String s: numbersList){
            intNumberList.add(Integer.valueOf(s));
        }

        // we make two more lists for Take and Skip
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        for (int i = 0; i < intNumberList.size(); i++) {
            if (i % 2 == 0){
                takeList.add(intNumberList.get(i));
            }else {
                skipList.add(intNumberList.get(i));
            }
        }
        // we create a result string
        String result = "";
        for (int i = 0; i < takeList.size(); i++) {
            int charactersToTake = takeList.get(i);
            nonNumbersList.remove(charactersToTake);
            result += nonNumbersList.get(charactersToTake);
            for (int j = 0; j < skipList.size(); j++) {
                int charactersToSkip = skipList.get(j);
                nonNumbersList.remove(charactersToSkip);
            }

        }
    }
}
