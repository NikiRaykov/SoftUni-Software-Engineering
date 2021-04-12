import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int group = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String dayOfTheWeek = scanner.nextLine();

        double price = 0.0;
        double priceForTenPeople = 0.0;

        switch (dayOfTheWeek){
            case "Friday":
                if (typeOfGroup.equals("Students")){
                    price = group * 8.45;
                    if (group >= 30){
                        price -= price * (15.0f/100.0f);
                    }
                }else if (typeOfGroup.equals("Business")){
                    priceForTenPeople = 10.90 * 10;
                    price = group * 10.90;
                    if (group >= 100){
                        price -= priceForTenPeople;
                    }
                }else if (typeOfGroup.equals("Regular")){
                    price = group * 15;
                    if (group >= 10 && group <= 20){
                        price -= price * (5.0f/100.0f);
                    }
                }
                break;


            case "Saturday":
                if (typeOfGroup.equals("Students")){
                    price = group * 9.80;
                    if (group >= 30){
                        price -= price * (15.0f/100.0f);
                    }
                }else if (typeOfGroup.equals("Business")){
                    priceForTenPeople = 10 * 15.60;
                    price = group * 15.60;
                    if (group >= 100){
                        price -= priceForTenPeople;
                    }
                }else if (typeOfGroup.equals("Regular")){
                    price = group * 20;
                    if (group >= 10 && group <= 20){
                        price -= price * (5.0f/100.0f);
                    }
                }
                break;


            case "Sunday":
                if (typeOfGroup.equals("Students")){
                    price = group * 10.46;
                    if (group >= 30){
                        price -= price * (15.0f/100.0f);
                    }
                }else if (typeOfGroup.equals("Business")){
                    priceForTenPeople = 10 * 16;
                    price = group * 16;
                    if (group >= 100){
                        price -= priceForTenPeople;
                    }
                }else if (typeOfGroup.equals("Regular")){
                    price = group * 22.50;
                    if (group >= 10 && group <= 20){
                        price -= price * (5.0f/100.0f);
                    }
                }
                break;
        }
        System.out.printf("Total price: %.2f", price);
    }
}
