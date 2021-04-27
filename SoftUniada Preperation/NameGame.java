import java.util.Scanner;

public class NameGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int points = 0; int maxPoints = 0; String winner = " ";

        while (!name.equals("Stop")){
            for (int j = 0; j < name.length(); j++) {
                int number = Integer.parseInt(scanner.nextLine());
                    if (number == name.charAt(j)){
                        points += 10;
                    }else {
                        points += 2;
                    }
            }

            if (points >= maxPoints){
                maxPoints = points;
                winner = name;
            }
            name = scanner.nextLine();
            points = 0;
        }
        System.out.printf("The winner is %s with %d points!", winner, maxPoints);
    }
}
