import java.util.*;

public class ProblemPastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] liquidsInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] ingredientsInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        List<String> foods = new ArrayList<>();
        foods.add("Biscuit");
        foods.add("Cake");
        foods.add("Pastry");
        foods.add("Pie");

        int biscuit = 0; int cake = 0; int pastry = 0; int pie = 0;
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
                        biscuit++;
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
                        foods.remove("Pie");
                        pie++;
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
        if (biscuit != 0 && cake != 0 && pastry != 0 && pie != 0){
            System.out.println("Great! You succeeded in cooking all the food!");
        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
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

        System.out.printf("Biscuit: %d%n", biscuit);
        System.out.printf("Cake: %d%n", cake);
        System.out.printf("Pie: %d%n", pie);
        System.out.printf("Pastry: %d", pastry);
    }
}
