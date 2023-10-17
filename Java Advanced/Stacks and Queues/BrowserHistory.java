import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> urls = new ArrayDeque<>();

        String currentUrl = null;

        while (!input.equals("Home")){

            if (input.equals("back")){
                if (urls.isEmpty()){
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    currentUrl = urls.pop();
                }
            }else {
                if (currentUrl != null){
                    urls.push(currentUrl);
                }
                currentUrl = input;
            }

            System.out.println(currentUrl);

            input = scanner.nextLine();
        }
    }
}
