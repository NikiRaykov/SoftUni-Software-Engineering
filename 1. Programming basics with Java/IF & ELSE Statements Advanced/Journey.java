import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {

     Scanner scanner = new Scanner(System.in);
     double budget = Double.parseDouble(scanner.nextLine());
     String season = scanner.nextLine();
     double expenses = 0;
     String destination = "";
     String accommodation = "";

     if (budget <= 100) {
         if (season.equals("summer")) {
             destination = "Bulgaria";
             accommodation = "Camp";
             expenses = budget * 0.3;
         }else if (season.equals("winter")){
             destination = "Bulgaria";
             accommodation = "Hotel";
             expenses = budget * 0.7;
         }
     }
     else if (budget <= 1000){
         if (season.equals("summer")) {
             destination = "Balkans";
             accommodation = "Camp";
             expenses = budget * 0.4;
         }else if (season.equals("winter")){
             destination = "Balkans";
             accommodation = "Hotel";
             expenses = budget * 0.8;
         }
     }
     else {
            destination = "Europe";
            accommodation = "Hotel";
            expenses = budget * 0.9;
     }

        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f", accommodation, expenses);
    }
}
