import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        StringBuilder output = new StringBuilder();

        for (String s: input){
            int n = s.length();
            output.append(s.repeat(n));
        }
        System.out.print(output);
    }
}
