import java.util.Scanner;

public class NumbersFromOneToTen {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = 1;

        while (num <= 10){
            System.out.println(num);
            num++;
        }
    }
}
