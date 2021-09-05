import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] bomb = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int[] casing = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> bombs = new ArrayDeque<>(); // queue
        ArrayDeque<Integer> casings = new ArrayDeque<>(); // stack

        for (int b: bomb){
            bombs.offer(b);
        }

        for (int c: casing){
            casings.push(c);
        }

        int daturaBombs = 40; int cherryBombs = 60; int smokeDecoyBombs = 120;
        int daturaBomb = 0; int cherryBomb = 0; int smokeDecoyBomb = 0;

        boolean isFilled = false;

        for (int i = 0; i < bombs.size(); i++) {
            for (int j = 0; j < casings.size(); j++) {


                if (daturaBomb > 2 && cherryBomb > 2 && smokeDecoyBomb > 2){
                    isFilled = true;
                    break;
                }

                if (!bombs.isEmpty() && !casings.isEmpty()){
                    int firstBomb = bombs.peek();
                    int lastCasing = casings.peek();
                    int sum = firstBomb + lastCasing;

                    if (sum == daturaBombs){
                        daturaBomb++;
                        bombs.remove();
                        casings.pop();
                    }else if (sum == cherryBombs){
                        cherryBomb++;
                        bombs.remove();
                        casings.pop();
                    }else if (sum == smokeDecoyBombs){
                        smokeDecoyBomb++;
                        bombs.remove();
                        casings.pop();
                    }else {
                        casings.pop();
                        casings.push(lastCasing - 5);
                    }
                }
                j--;
            }
        }

        if (isFilled){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombs.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else {
            System.out.println("Bomb Effects: " + bombs.toString().replaceAll("\\p{P}" ,"").replaceAll("\\s+", ", "));
        }

        if (casings.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }else {
            System.out.println("Bomb Casings: " + casings.toString().replaceAll("\\p{P}" ,"").replaceAll("\\s+", ", "));
        }

        System.out.println("Cherry Bombs: " + cherryBomb);
        System.out.println("Datura Bombs: " + daturaBomb);
        System.out.println("Smoke Decoy Bombs: " + smokeDecoyBomb);
    }
}
