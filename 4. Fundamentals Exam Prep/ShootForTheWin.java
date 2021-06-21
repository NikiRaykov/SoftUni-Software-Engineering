import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine(); int count = 0;

        while (!command.equals("End")){
            int shot = Integer.parseInt(command);

            if (shot >= 0 && shot <= targets.size() - 1){
                if (targets.get(shot) != -1){
                    int targetShot = targets.get(shot);
                    targets.set(shot, -1);
                    count++;

                    for (int i = 0; i < targets.size(); i++) {
                        int nextTarget = targets.get(i);
                        if (nextTarget != -1){
                            if (nextTarget > targetShot){
                                targets.set(targets.indexOf(nextTarget), nextTarget - targetShot);
                            }else {
                                targets.set(targets.indexOf(nextTarget), nextTarget + targetShot);
                            }
                        }
                    }
                }
            }

            command = scanner.nextLine();
        }

        System.out.printf("Shot targets: %d -> ",count);
        for (Integer n: targets){
            System.out.print(n + " ");
        }
    }
}
