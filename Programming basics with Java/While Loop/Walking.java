import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int stepsGoal = 10000;
        int stepsCounter = 0;

        while (stepsCounter < stepsGoal){
            String command = scanner.nextLine();
            if (command.equals("Going home")){
              int stepsToHome = Integer.parseInt(scanner.nextLine());
                stepsCounter += stepsToHome;
                break;
            }
          int steps = Integer.parseInt(command);
            stepsCounter += steps;
        }
        if (stepsCounter >= stepsGoal){
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!", stepsCounter - stepsGoal);
        }else{
            System.out.printf("%d more steps to reach goal.", stepsGoal - stepsCounter);
        }
    }
}
