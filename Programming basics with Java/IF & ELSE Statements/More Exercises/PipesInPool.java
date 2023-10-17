import java.util.Scanner;

public class PipesInPool {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int volume = Integer.parseInt(scanner.nextLine());
        int pipe1 = Integer.parseInt(scanner.nextLine());
        int pipe2 = Integer.parseInt(scanner.nextLine());
        double hours = Double.parseDouble(scanner.nextLine());

        double pipeLiters1 = pipe1 * hours;
        double pipeLiters2 = pipe2 * hours;
        double liters = pipeLiters1 + pipeLiters2;
        double percent = (liters / volume) * 100;
        double pipePercent1 = (pipeLiters1 / liters) * 100;
        double pipePercent2 = (pipeLiters2 / liters) * 100;

        if (liters <= volume) {
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%.", percent, pipePercent1, pipePercent2);
        }
        else if (liters > volume) {
            double litersOverflow = liters - volume;
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", hours, litersOverflow);
        }
        else {
            System.out.println("The pool is closed.");
        }
    }
}