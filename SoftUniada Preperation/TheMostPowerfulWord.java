import java.util.Scanner;

public class TheMostPowerfulWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        double valueOfTheWord = 0; double maxWord = 0; String mostPowerfulWord = " ";

        while (!word.equals("End of words")){
            valueOfTheWord = 0;
            for (int i = 0; i < word.length(); i++) {
                valueOfTheWord += word.charAt(i);
            }

            if (word.charAt(0) == 'a' || word.charAt(0) == 'e'
                    || word.charAt(0) == 'i' || word.charAt(0) == 'o'
                    || word.charAt(0) == 'u' || word.charAt(0) == 'y' ||
                    word.charAt(0) == 'A' || word.charAt(0) == 'E' || word.charAt(0) == 'I'
                    || word.charAt(0) == 'O' || word.charAt(0) == 'U' || word.charAt(0) == 'Y'){
                    valueOfTheWord = valueOfTheWord * word.length();
            }else {
                    valueOfTheWord = Math.floor(valueOfTheWord / 3);
            }

            if (valueOfTheWord > maxWord){
                maxWord = valueOfTheWord;
                mostPowerfulWord = word;
            }

            word = scanner.nextLine();
        }
        System.out.printf("The most powerful word is %s - %.0f", mostPowerfulWord, maxWord);
    }
}
