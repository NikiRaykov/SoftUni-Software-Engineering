import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder activationKey = new StringBuilder(scanner.nextLine());


        String commands = scanner.nextLine();

        while (!commands.equals("Generate")){
            String[] tokens = commands.split(">>>");

            switch (tokens[0]){
                case "Contains":
                    String substring = tokens[1];
                    if (activationKey.toString().contains(substring)){
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    }else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String subCommand = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);

                    for (int i = startIndex; i < endIndex; i++) {
                        char currentChar = activationKey.charAt(i);
                        switch (subCommand){
                            case "Upper":
                                activationKey.setCharAt(i, Character.toUpperCase(currentChar));
                                break;
                            case "Lower":
                                activationKey.setCharAt(i, Character.toLowerCase(currentChar));
                                break;
                        }
                    }
                    System.out.println(activationKey);
                    break;

                case "Slice":
                    int beginIndex = Integer.parseInt(tokens[1]);
                    int end = Integer.parseInt(tokens[2]);

                    activationKey.delete(beginIndex, end);
                    System.out.println(activationKey);
                        break;

            }

            commands = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", activationKey);
    }
}
