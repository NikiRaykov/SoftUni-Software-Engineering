import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int tabs = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < tabs; i++) {
            String webSite = scanner.nextLine();

            if (webSite.equals("Facebook")){
                salary = salary - 150;
            }
            else if (webSite.equals("Instagram")){
                salary = salary - 100;
            }
            else if (webSite.equals("Reddit")){
                salary = salary - 50;
            }
        }

        if (salary <= 0){
            System.out.println("You have lost your salary.");
        }
        else {
            System.out.printf("%d", salary);
        }
    }
}
