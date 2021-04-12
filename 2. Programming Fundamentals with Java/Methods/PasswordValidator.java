import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {

        passwordValidator();
    }

    public static void passwordValidator(){
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        if (password.length() < 6 || password.length() > 10){
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!password.matches("[a-zA-Z0-9]*")){
            System.out.println("Password must consist only of letters and digits");
        }
        if (!password.matches("^(?=.*?\\d.*\\d)[a-zA-Z0-9]{8,}$")){
            System.out.println("Password must have at least 2 digits");
        }else {
            System.out.println("Password is valid");
        }
    }
}
