import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        String commands = scanner.nextLine();

        while (!commands.equals("Decode")){
            String[] instructions = commands.split("\\|");
            String instruction = instructions[0];

            switch (instruction){
                case "Move":
                    int n = Integer.parseInt(instructions[1]);
                    message = new StringBuilder(message.toString().replaceAll("^(.{" + n + "})(.*)", "$2$1"));
                    break;
                case "Insert":
                    int index = Integer.parseInt(instructions[1]);
                    String value = instructions[2];
                    message.insert(index, value);
                    break;
                case "ChangeAll":
                    String substringToChange = instructions[1];
                    String replacement = instructions[2];

                    if (message.toString().contains(substringToChange)){
                        message = new StringBuilder(message.toString().replace(substringToChange, replacement));
                    }
                    break;
            }

            commands = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + message);
    }
}
