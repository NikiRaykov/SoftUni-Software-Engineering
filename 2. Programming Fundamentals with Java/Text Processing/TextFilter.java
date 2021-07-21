import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        String input = "";

        for (String banWord: bannedWords){
            input = text.replaceAll(banWord,new String(new char[banWord.length()]).replace('\0', '*'));
        }
        System.out.println(input);
    }
}
