import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String day = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        boolean isValid = false;

        switch (day){
            case "Weekday":
                if (age < 0){
                isValid = true;
                break;
                 }
                else if (age <= 18){
                    System.out.println("12$");
                }else if (age <= 64){
                    System.out.println("18$");
                }else if (age <= 122){
                    System.out.println("122$");
                }
                break;
            case "Weekend":
                if (age < 0){
                isValid = true;
                break;
            }
                else if (age <= 18){
                    System.out.println("15$");
                }else if (age <= 64){
                    System.out.println("20$");
                }else if (age <= 122){
                    System.out.println("15$");
                }

                break;
            case "Holiday":
                if (age < 0){
                     isValid = true;
                            break;
                 }
              else  if (age <= 18){
                    System.out.println("5$");
                }else if (age <= 64){
                    System.out.println("12$");
                }else if (age <= 122) {
                    System.out.println("10$");
                }
                break;
        }
        if (isValid){
            System.out.println("Error!");
        }
    }
}



