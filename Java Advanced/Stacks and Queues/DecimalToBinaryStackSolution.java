import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryStackSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());

        if (decimal == 0){
            System.out.println(0);
            return;
        }

        ArrayDeque<Integer> binaryNumber = new ArrayDeque<>();


        while (decimal != 0){
            binaryNumber.push(decimal % 2);
            decimal /= 2;
        }

        for (Integer digit : binaryNumber){
            System.out.print(binaryNumber.pop());
        }
    }
}
