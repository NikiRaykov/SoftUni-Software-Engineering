import java.util.Arrays;
import java.util.Scanner;
 
public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
 
        String input = scan.nextLine();
        while (!"end".equals(input)){
            String[] commands = input.split("\\s+");
            String token = commands[0];
            switch (token){
                case "swap":
                    int index1 = Integer.parseInt(commands[1]);
                    int index2 = Integer.parseInt(commands[2]);
                    if (index1 >= 0 && index1 < numbers.length && index2 >= 0 && index2 < numbers.length){
                        int temp = numbers[index1];
                        numbers[index1] = numbers[index2];
                        numbers[index2] = temp;
                    }
                    break;
                case "multiply":
                    index1 = Integer.parseInt(commands[1]);
                    index2 = Integer.parseInt(commands[2]);
                    if (index1 >= 0 && index1 < numbers.length && index2 >= 0 && index2 < numbers.length){
                        int temp = numbers[index1] * numbers[index2];
                         numbers[index1] = temp;
                    }
                    break;
                case "decrease":
                    for (int i = 0; i <numbers.length ; i++) {
                        int temp = numbers[i] - 1;
                        numbers[i] = temp;
                    }
                    break;
            }
 
            input = scan.nextLine();
        }
        for (int i = 0; i <numbers.length ; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1){
                System.out.print(", ");
            }
        }
    }
}
