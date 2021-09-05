import java.util.*;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] liquidsInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] ingredientsInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        List<String> foods = new ArrayList<>();
        foods.add("Bread");
        foods.add("Cake");
        foods.add("Pastry");
        foods.add("Fruit Pie");

        int bread = 0; int cake = 0; int pastry = 0; int fruitPie = 0;
        //FIFO
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        for (int j : liquidsInput) {
            liquids.offer(j);
        }

        //LIFO
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        for (int i: ingredientsInput){
            ingredients.push(i);
        }

        for (int i = 0; i < liquids.size(); i++) {
            for (int j = 0; j < ingredients.size(); j++) {
                boolean isEmpty = false;
                if (!liquids.isEmpty() && !ingredients.isEmpty()){
                    int firstLiquid = liquids.peek();
                    int lastIngredient = ingredients.peek();
                    int sum = firstLiquid + lastIngredient;
                    if (sum == 25){
                        ingredients.pop(); liquids.remove();
                        foods.remove("Biscuit");
                        bread++;
                    }else if (sum == 50){
                        ingredients.pop(); liquids.remove();
                        foods.remove("Cake");
                        cake++;
                    }else if (sum == 75){
                        ingredients.pop(); liquids.remove();
                        foods.remove("Pastry");
                        pastry++;
                    }else if (sum == 100) {
                        ingredients.pop(); liquids.remove();
                        foods.remove("Fruit Pie");
                        fruitPie++;
                    }else {
                        liquids.remove();
                        ingredients.pop();
                        ingredients.push(lastIngredient += 3);
                    }
                }else {
                    isEmpty = true;
                    break;
                }
                j--;
            }
        }
        if (bread != 0 && cake != 0 && pastry != 0 && fruitPie != 0){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }



        if (liquids.isEmpty()){
            System.out.println("Liquids left: none");
        }else {
            System.out.println("Liquids left: " + liquids.toString().replaceAll("\\p{P}" ,"").replaceAll("\\s+", ", "));
        }

        if (ingredients.isEmpty()){
            System.out.println("Ingredients left: none");
        }else {
            System.out.println("Ingredients left: " + ingredients.toString().replaceAll("\\p{P}" ,"").replaceAll("\\s+", ", "));
        }

        System.out.printf("Bread: %d%n", bread);
        System.out.printf("Cake: %d%n", cake);
        System.out.printf("Fruit Pie: %d%n", fruitPie);
        System.out.printf("Pastry: %d", pastry);
    }
}
