import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\\\");
        String[] output = input[input.length - 1].split("\\.");
        System.out.printf("File name: %s%n", output[0]);
        System.out.printf("File extension: %s", output[1]);
    }
}
