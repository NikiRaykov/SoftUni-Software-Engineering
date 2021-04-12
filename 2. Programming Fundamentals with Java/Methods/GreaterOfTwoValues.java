import java.sql.SQLOutput;
import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        int firstNumber = 0; int secondNumber = 0;
        String first =""; String second = "";
        String firstSymbol = ""; String secondSymbol = "";

        if (type.equals("int")){

             int maxIs = getMax(firstNumber, secondNumber);
             System.out.println(maxIs);
        }
        else if (type.equals("string")){
            first = scanner.nextLine();
            second = scanner.nextLine();
            String maxString = getMax(first, second);
            System.out.println(maxString);
        }
        else if (type.equals("char")){
            firstSymbol = scanner.nextLine();
            secondSymbol = scanner.nextLine();
            String biggerIs = getMax(firstSymbol, secondSymbol);
            System.out.println(biggerIs);
        }
    }

    private static int getMax(int firstNumber, int secondNumber) {
        return Math.max(firstNumber, secondNumber);
    }

    private static String getMax(String first, String second){
        if (first.compareTo(second) >= 0){
            return first;
        }
            return second;
    }

    private static char getMax(char firstSymbol, char secondSymbol){
        if (firstSymbol > secondSymbol){
            return firstSymbol;
        }
            return secondSymbol;
    }
}
