import java.util.Scanner;

public class PasswordGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputPass = scanner.nextLine();

        String secretPass = "s3cr3t!P@ssw0rd";

        if (inputPass.equals(secretPass)) {
            System.out.println("Welcome");
        } else {
            System.out.println("Wrong password!");
        }
    }
}
