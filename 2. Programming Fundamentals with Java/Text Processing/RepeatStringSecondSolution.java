import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepeatStringSecondSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");

        List<String> output = new ArrayList<>();

        for (String s: arr){
            output.add(s.repeat(s.length()));
        }
        System.out.println(String.join("", output));
    }
}
