import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int  b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int sumFinal = sum(a, b, c);
        System.out.println(sumFinal);

    }

    public static int sum(int a, int b, int c){
        return (a + b) - c;
    }
}
