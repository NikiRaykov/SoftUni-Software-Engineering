import java.util.Scanner;

public class PetShop {
        public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
                int dogs = Integer.parseInt(scan.nextLine());
                int animals = Integer.parseInt(scan.nextLine());

                double sumDogs = dogs * 2.50;
                double sumAnimals = animals * 4;

                double result = sumDogs + sumAnimals;
                System.out.println(result);
        }

}