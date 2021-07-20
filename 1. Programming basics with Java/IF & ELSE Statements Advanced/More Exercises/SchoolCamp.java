import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String season = scanner.nextLine();
        String group = scanner.nextLine();
        int students = Integer.parseInt(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        double price = 0;
        String vacation = "";
        String sport = "";

        if (season.equals("Winter")) {
            if (group.equals("girls")){
                price = (nights * 9.60) * students;
                sport = "Gymnastics";
            }
            else if (group.equals("mixed")){
                price = (nights * 10) * students;
                sport = "Ski";
            }
            else if (group.equals("boys")){
                price = (nights * 9.60) * students;
                sport = "Judo";
            }
        }
        else if (season.equals("Spring")){
            if (group.equals("girls")){
                price = (nights * 7.20)* students;
                sport = "Athletics";
            }
            else if (group.equals("mixed")){
                price = (nights * 9.50) * students;
                sport = "Cycling";
            }
            else if (group.equals("boys")){
                price = (nights * 7.20) * students;
                sport = "Tennis";
            }
        }
        else if (season.equals("Summer")){
            if (group.equals("girls")){
                price = (nights * 15) * students;
                sport = "Volleyball";
            }
            else if (group.equals("mixed")){
                price = (nights * 20) * students;
                sport = "Swimming";
            }
            else if (group.equals("boys")){
                price = (nights * 15) * students;
                sport = "Football";
            }
        }
        if (students >= 50) {
            price = price - (price * 0.50);
        }
        else if (students >= 20) {
            price = price - (price * 0.15);
        }
        else if (students >= 10) {
            price = price * 0.95;
        }

        System.out.printf("%s %.2f lv.", sport, price);
    }
}
