import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String command = scanner.nextLine();
        StringBuilder newRawPass = new StringBuilder();
        String newPass = ""; boolean isConverted = false;

        while(!command.equals("Done")){
            String[] tokens = command.split(" ");
            switch (tokens[0]){
                case "TakeOdd":
                    for (int i = 0; i < text.length(); i++) {
                        if (i % 2 != 0){
                            char ch = text.charAt(i);
                            newRawPass.append(ch);
                        }
                    }
                    System.out.println(newRawPass);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    newRawPass.replace(index, index + length, "");
                    System.out.println(newRawPass);
                    break;
                case "Substitute":
                    if (!isConverted){
                        newPass = newRawPass.toString();
                        isConverted = true;
                    }

                    if (newPass.contains(tokens[1])){
                        newPass = newPass.replace(tokens[1], tokens[2]);
                        System.out.println(newPass);
                    }else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.print("Your password is: " + newPass);
    }
}
