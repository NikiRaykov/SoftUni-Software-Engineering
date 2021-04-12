import java.util.Scanner;

public class Login {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String passwordTry = scanner.nextLine();
        StringBuilder password = new StringBuilder();
        int counter = 0; boolean blocked = false;

        password.append(username);
        password.reverse();

        while (!passwordTry.contentEquals(password)){
            counter++;

            if (counter > 3){
                blocked = true;
                break;
            }
            System.out.println("Incorrect password. Try again.");
            passwordTry = scanner.nextLine();
        }

        if (blocked){
            System.out.printf("User %s blocked!", username);
        }else{
            System.out.printf("User %s logged in.", username);
        }
    }
}
