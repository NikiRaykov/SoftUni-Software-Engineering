import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int output = stringMultiply(input);
        System.out.println(output);

    }
    public static int stringMultiply(String[] input){
        int sum = 0;
        for (int i = 0; i < Math.min(input[0].length(), input[1].length()); i++) {
            sum += input[0].charAt(i) * input[1].charAt(i);
        }

        if (input[0].length() > input[1].length()){
            for (int i = input[1].length(); i < input[0].length(); i++) {
                sum += input[0].charAt(i);
            }
        }else {
            for (int i = input[0].length(); i < input[1].length(); i++) {
                sum += input[1].charAt(i);
            }
        }
        return sum;
    }
}
