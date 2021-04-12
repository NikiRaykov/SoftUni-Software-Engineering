import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String newString = middleCharacter(line);
        System.out.print(newString + "");
    }

    public static String middleCharacter(String line){
        int length, middle;

        if (line.length() % 2 != 0){
            middle = line.length() / 2;
            length = 1;
        }else {
            middle = line.length() / 2 - 1;
            length = 2;
        }
        return line.substring(middle, middle + length);
    }
}
