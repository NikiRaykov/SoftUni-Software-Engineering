import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder password = new StringBuilder(scanner.nextLine());

        String commands = scanner.nextLine();

        while (!commands.equals("Done")){
            String[] tokens = commands.split("\\s+");
            String command = tokens[0];

            switch (command){
                case "TakeOdd":
                    StringBuilder rawPassword = new StringBuilder();
                    for (int i = 0; i < password.length(); i++) {
                        if (i % 2 != 0){
                            rawPassword.append(password.charAt(i));
                        }
                    }
                    password = new StringBuilder(rawPassword);
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);

                    password.delete(index, index + length);
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];

                    if (password.toString().contains(substring)){
                        password = new StringBuilder(password.toString().replace(substring, substitute));
                        System.out.println(password);
                    }
                    else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            commands = scanner.nextLine();
        }
        System.out.println("Your password is: " + password);
    }
}
