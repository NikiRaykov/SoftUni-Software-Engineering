import java.util.Scanner;

public class MovieStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budgetForActors = Double.parseDouble(scanner.nextLine());
        double salary = 0.0; boolean outOfMoney = false;

        String actorName = scanner.nextLine();
        while (!actorName.equals("ACTION")){

            if (actorName.length() <= 15){
                salary = Double.parseDouble(scanner.nextLine());

                if (budgetForActors < salary){
                    outOfMoney = true;
                    break;
                }
                budgetForActors -= salary;
            }else {
                salary = budgetForActors * (20.0f/100.0f);
                budgetForActors -= salary;
            }


            actorName = scanner.nextLine();
        }
        if (outOfMoney){
            System.out.printf("We need %.2f leva for our actors.", Math.abs(budgetForActors - salary));
        }else {
            System.out.printf("We are left with %.2f leva.", budgetForActors);
        }
    }
}
