import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        palindromeIntegers();
    }

    public static void palindromeIntegers(){
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int reversedNumber = 0;
        while (!line.equals("END")){
            int number = Integer.parseInt(line);
            while (number != 0){
                int digit = number % 10;
                reversedNumber = reversedNumber * 10 + digit;
                number /= 10;
            }
            number = Integer.parseInt(line);
            if (number == reversedNumber){
                System.out.println("true");
            }else {
                System.out.println("false");
            }
            reversedNumber = 0;
            line = scanner.nextLine();
        }
    }
}
