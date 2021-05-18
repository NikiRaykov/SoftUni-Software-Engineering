import java.util.Scanner;

public class AluminumJoinery {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int joinery = Integer.parseInt(scanner.nextLine());
        String typeJoinery = scanner.nextLine();
        String receiveType = scanner.nextLine();

        double price = 0.0;

        switch (typeJoinery){
            case "90X130":
                if (joinery <10){
                    break;
                }

                price = joinery * 110;

                if (joinery >= 30 && joinery <= 60){
                    price -= price * (5.00f/100.0f);
                }
                else if (joinery > 60){
                    price -= price * (8.00f/100.0f);
                }

                if (receiveType.equals("With delivery")){
                    price += 60;
                }

                if (joinery > 99){
                    price -= price * (4.00f/100.0f);
                }

                break;

            case "100X150":

                if (joinery <10){
                    break;
                }
                price = joinery * 140;

                if (joinery >= 40 && joinery <= 80) {
                    price -= price * (6.00f / 100.0f);
                }
                else if (joinery > 80){
                    price -= price * (10.00f/100.0f);
                }

                if (receiveType.equals("With delivery")){
                    price += 60;
                }

                if (joinery > 99){
                    price -= price * (4.00f/100.0f);
                }

                break;

            case "130X180":
                if (joinery < 10){
                    break;
                }
                price = joinery * 190;

                if (joinery >= 20 && joinery <= 50){
                    price -= price * (7.00f/100.0f);
                }
                else if (joinery > 50){
                    price -= price * (12.00f/100.0f);
                }

                if (receiveType.equals("With delivery")){
                    price += 60;
                }

                if (joinery > 99){
                    price -= price * (4.00f/100.0f);
                }


                break;

            case "200X300":
                if (joinery <10){
                    break;
                }
                price = joinery * 250;

                if (joinery >= 25 && joinery <= 50){
                    price -= price * (9.00f/100.0f);
                }
                else if (joinery > 50){
                    price -= price * (14.00f/100.0f);
                }

                if (receiveType.equals("With delivery")){
                    price += 60;
                }

                if (joinery > 99){
                    price -= price * (4.00f/100.0f);
                }

                break;
        }

        if (joinery < 10){
            System.out.println("Invalid order");
        }
        else {
            System.out.printf("%.2f BGN", price);
        }

    }
}
