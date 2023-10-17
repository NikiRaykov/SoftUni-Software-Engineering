import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); // колко хода ще продължи играта
        double points = 0;
        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        double p4 = 0;
        double p5 = 0;
        double p6 = 0;

        for (int i = 0; i < n ; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine()); // every number that we check

            if (currentNumber >= 0 && currentNumber <= 9){
                    points = points + (currentNumber * (20.0f/100.0f));
                    p1++;
            }
            else if (currentNumber >= 10 && currentNumber <= 19){
                points = points + (currentNumber * (30.0f/100.0f));
                p2++;
            }
            else if (currentNumber >= 20 && currentNumber <= 29){
                points = points + (currentNumber * (40.0f/100.0f));
                p3++;
            }
            else if (currentNumber >= 30 && currentNumber <= 39){
                points += 50;
                p4++;
            }
            else if (currentNumber >= 40 && currentNumber <= 50){
                    points += 100;
                    p5++;
            }
            else if (currentNumber < 0 || currentNumber > 50){
                    points /= 2;
                    p6++;
            }
        }
        System.out.printf("%.2f%n", points);
        System.out.printf("From 0 to 9: %.2f%%%n", (p1/n) * 100);
        System.out.printf("From 10 to 19: %.2f%%%n", (p2/n) * 100);
        System.out.printf("From 20 to 29: %.2f%%%n", (p3/n) * 100);
        System.out.printf("From 30 to 39: %.2f%%%n", (p4/n) * 100);
        System.out.printf("From 40 to 50: %.2f%%%n", (p5/n) * 100);
        System.out.printf("Invalid numbers: %.2f%%%n", (p6/n) * 100);
    }
}
