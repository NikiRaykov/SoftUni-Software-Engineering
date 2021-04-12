import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {

     Scanner scanner = new Scanner(System.in);

     String flowersType = scanner.nextLine();
     int flowersNumber = Integer.parseInt(scanner.nextLine());
     int budget = Integer.parseInt(scanner.nextLine());
     double flowerPrice = 0;

     switch (flowersType){
         case "Roses":
             flowerPrice = flowersNumber * 5;
             break;

         case "Dahlias":
             flowerPrice = flowersNumber * 3.80;
             break;

         case "Tulips":
             flowerPrice = flowersNumber * 2.80;
             break;

         case "Narcissus":
             flowerPrice = flowersNumber * 3;
             break;

         case "Gladiolus":
             flowerPrice = flowersNumber * 2.50;
             break;
     }

     if (flowersNumber > 80 && flowersType.equals("Roses")){
            flowerPrice *= 0.9;
     }else if (flowersNumber > 90 && flowersType.equals("Dahlias")){
            flowerPrice *= 0.85;
     }else if (flowersNumber > 80 && flowersType.equals("Tulips")){
            flowerPrice *= 0.85;
     }else if (flowersNumber < 120 && flowersType.equals("Narcissus")){
            flowerPrice = flowerPrice + (flowerPrice * 0.15);
     }else if (flowersNumber < 80 && flowersType.equals("Gladiolus")){
         flowerPrice = flowerPrice + (flowerPrice * 0.20);
     }

     if (flowerPrice <= budget){
         System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersNumber,flowersType, Math.abs(flowerPrice - budget));
     }else{
         System.out.printf("Not enough money, you need %.2f leva more.", flowerPrice - budget);
     }
    }
}
