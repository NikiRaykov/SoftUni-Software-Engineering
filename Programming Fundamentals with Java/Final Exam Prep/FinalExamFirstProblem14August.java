import java.util.Scanner;

public class FinalExamFirstProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String email = scanner.nextLine();

        String commands = scanner.nextLine();

        while (!commands.equals("Complete")){
            String[] tokens = commands.split("\\s+");
            String command = tokens[0];

            switch (command){
                case "Make":
                    if (tokens[1].equals("Upper")){
                        email = email.toUpperCase();
                        System.out.println(email);
                    }else if (tokens[1].equals("Lower")){
                        email = email.toLowerCase();
                        System.out.println(email);
                    }
                    break;

                case "GetDomain":
                    int count = Integer.parseInt(tokens[1]);
                    int len = email.length();
                    System.out.println(email.substring(len - count, len));
                    break;

                case "GetUsername":
                    if (!email.contains("@")){
                        System.out.printf("The email %s doesn't contain the @ symbol.%n", email);
                    }else {
                        for (int i = 0; i < email.length(); i++) {
                            if (email.charAt(i) != '@'){
                                System.out.print(email.charAt(i));
                            }else {
                                break;
                            }
                        }
                        System.out.println();
                    }
                    break;
                case "Replace":
                    String ch = tokens[1];
                    System.out.println(email.replace(ch, "-"));
                    break;

                case "Encrypt":
                    for (int i = 0; i < email.length(); i++) {
                        System.out.print((int)email.charAt(i) + " ");
                    }
                    break;
            }


            commands = scanner.nextLine();
        }

    }

}
