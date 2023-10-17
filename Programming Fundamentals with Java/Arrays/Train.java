import java.util.Arrays;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int wagons = Integer.parseInt(scanner.nextLine());
        int[] people = new int[wagons];
        int sum = 0;

        for (int i = 0; i < people.length; i++) {
            people[i] = scanner.nextInt();
            sum += people[i];
        }

        for (int j : people){
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.println(sum);
        }
    }

