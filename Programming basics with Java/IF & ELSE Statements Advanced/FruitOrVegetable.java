import java.util.Scanner;

public class FruitOrVegetable {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String fruitOrVegie = scanner.nextLine();


        if (fruitOrVegie.equals("banana") || fruitOrVegie.equals("apple") || fruitOrVegie.equals("kiwi")
                || fruitOrVegie.equals("cherry") || fruitOrVegie.equals("lemon") || fruitOrVegie.equals("grapes")){
            System.out.println("fruit");
        }
        else if (fruitOrVegie.equals("tomato") || fruitOrVegie.equals("cucumber") || fruitOrVegie.equals("pepper")
                || fruitOrVegie.equals("carrot")){
            System.out.println("vegetable");
        }
        else {
            System.out.println("unknown");
        }
    }
}
