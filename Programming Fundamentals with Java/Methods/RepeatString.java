import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        String newString = threeTimes(s, n);
        System.out.println(newString);
    }

    private static String threeTimes(String s, int n){
        return s.repeat(n);
    }
}
