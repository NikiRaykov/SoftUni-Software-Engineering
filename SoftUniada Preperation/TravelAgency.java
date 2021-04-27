import java.util.Scanner;

public class TravelAgency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String town = scanner.nextLine();
        String packageType =  scanner.nextLine();
        String vipDiscount = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        boolean isValid = true;

        if (days < 1){
            System.out.println("Days must be positive number!");
            return;
        }

        double price = 0;
        switch (town){
            case "Bansko":
            case "Borovets":
                if (packageType.equals("noEquipment")){
                    if (days > 7){
                        days--;
                    }
                    price = days * 80;
                    if (vipDiscount.equals("yes")){
                        price -= price * (5.0f/100.0f);
                    }
                }else if (packageType.equals("withEquipment")){
                    if (days > 7){
                        days--;
                    }
                    price = days * 100;
                    if (vipDiscount.equals("yes")){
                        price -= price * (10.0f/100.0f);
                    }
                }

                break;

            case "Varna":
            case "Burgas":
                if (packageType.equals("withBreakfast")){
                    if (days > 7){
                        days--;
                    }
                    price = days * 130;
                    if (vipDiscount.equals("yes")){
                        price -= price * (12.0f/100.0f);
                    }
                }else if (packageType.equals("noBreakfast")){
                    if (days > 7){
                        days--;
                    }
                    price = days * 100;
                    if (vipDiscount.equals("yes")){
                        price -= price * (7.0f/100.0f);
                    }
                }
                break;

            default:
                isValid = false;
                break;
        }

        if (!isValid){
            System.out.println("Invalid input!");
        }else {
            System.out.printf("The price is %.2flv! Have a nice time!", price);
        }

    }
}
