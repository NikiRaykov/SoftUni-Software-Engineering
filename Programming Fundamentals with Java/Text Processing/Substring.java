import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String remove = scanner.nextLine();
        StringBuilder output = new StringBuilder(scanner.nextLine());
        int index;

        while ((index = output.indexOf(remove)) != -1){
            output.delete(index, index + remove.length());
        }
        System.out.println(output);
    }
}
