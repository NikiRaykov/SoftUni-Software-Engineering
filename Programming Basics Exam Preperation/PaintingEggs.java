import java.util.Scanner;

public class PaintingEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String size = scanner.nextLine();
        String color = scanner.nextLine();
        int numbers = Integer.parseInt(scanner.nextLine());

        double price = 0; double expenses = 0;

        switch (size){
            case "Large":
                if (color.equals("Red")){
                    price = numbers * 16;
                }else if (color.equals("Green")){
                    price = numbers * 12;
                }else if (color.equals("Yellow")){
                    price = numbers * 9;
                }
                break;

            case "Medium":
                if (color.equals("Red")){
                    price = numbers * 13;
                }else if (color.equals("Green")){
                    price = numbers * 9;
                }else if (color.equals("Yellow")){
                    price = numbers * 7;
                }
                break;

            case "Small":
                if (color.equals("Red")){
                    price = numbers * 9;
                }else if (color.equals("Green")){
                    price = numbers * 8;
                }else if (color.equals("Yellow")){
                    price = numbers * 5;
                }
                break;
        }
        expenses = price *(35.0f/100.0f);
        price -= expenses;

        System.out.printf("%.2f leva.", price);
    }
}
