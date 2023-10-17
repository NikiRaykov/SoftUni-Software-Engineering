import java.util.Scanner;

public class MultiplyEvenByOdds {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int multiply = getMultipleOfEvensAndOdds(number);
        System.out.println(multiply);
    }

    private static int getMultipleOfEvensAndOdds(int number){
        int sumEven = 0; int sumOdd = 0;
        String temp = Integer.toString(number);
        int n[] = new int[temp.length()];

        for (int i = 0; i < Math.abs(temp.length()); i++) {
            n[i] = temp.charAt(i) - '0';
            if (n[i] % 2 == 0){
                sumEven += n[i];
            }else {
                sumOdd += n[i];
            }
        }

        return Math.abs(sumEven * sumOdd);
    }
}
