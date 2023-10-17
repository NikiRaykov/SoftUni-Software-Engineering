import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());

        double priceStudio = 0;
        double priceApartment = 0;

        switch (month) {
            case "May":
            case "October":
                priceStudio = nights * 50;
                priceApartment = nights * 65;
                break;

            case "June":
            case "Septebmber":
                priceStudio = nights * 75.20;
                priceApartment = nights * 68.70;
                break;

            case "July":
            case "August":
                priceStudio = nights * 76;
                priceApartment = nights * 77;
                break;
        }
        if (nights > 7 && nights < 14){
            if (month.equals("May") || month.equals("October")){
                priceStudio = priceStudio * 0.5;
            }
        }else if (nights > 14){
            priceApartment = priceApartment * 0.9;
        }
                if (month.equals("May") || month.equals("October")){
                    priceStudio = priceStudio * 0.7;
                }
                else if (month.equals("June") || month.equals("September")){
                    priceStudio = priceStudio * 0.8;
                }
        System.out.printf("Apartment: %.2f lv.", priceApartment);
        System.out.println();
        System.out.printf("Studio: %.2f lv.", priceStudio);

    }
}


