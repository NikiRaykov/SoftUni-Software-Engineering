import java.util.Scanner;

public class FuelTank2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double gasolinePrice = 2.22;
        double dieselPrice = 2.33;
        double gasPrice = 0.93;

        String fuelType = scanner.nextLine();
        double fuelLiters = Double.parseDouble(scanner.nextLine());
        String discount = scanner.nextLine();
        double price = 0.0;

        switch (fuelType){
            case "Gas":
                if (discount.equals("Yes")){
                    gasPrice -= 0.08;
                }
                price = gasPrice * fuelLiters;
                break;

            case "Gasoline":
                if (discount.equals("Yes")){
                    gasolinePrice = gasolinePrice - 0.18;
                }
                price = gasolinePrice * fuelLiters;
                break;

            case "Diesel":
                if (discount.equals("Yes")){
                    dieselPrice = dieselPrice - 0.12;
                }
                price = dieselPrice * fuelLiters;
                break;
        }

        if (fuelLiters >= 20 && fuelLiters <= 25){
            price -= price * (8.0f/100.0f);
        }
        else if (fuelLiters > 25){
            price -= price * (10.0f/100.0f);
        }

        System.out.printf("%.2f lv.", price);
    }
}
