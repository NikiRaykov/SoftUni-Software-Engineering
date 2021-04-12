import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String first = scanner.nextLine();
        String second = scanner.nextLine();

        String[] array1 = first.split(" ");
        String[] array2 = second.split(" ");

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i].equals(array2[j])){
                    System.out.print(array1[i] + " ");
                }
            }
        }
    }
}
