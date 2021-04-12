import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int startPoint = Integer.parseInt(scanner.nextLine());
        int finalPoint = Integer.parseInt(scanner.nextLine());

        char c = 0; StringBuilder outPut = new StringBuilder();

        for (int i = startPoint; i <= finalPoint; i++) {
                c = (char) i;
                outPut.append(c).append(" ");
        }
        System.out.print(outPut);
    }
}
