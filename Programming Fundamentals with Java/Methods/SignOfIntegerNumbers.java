import java.util.Scanner;
public class SignOfIntegerNumbers {
    public static void main(String[] args) {
        myMethod();
    }

    public static void myMethod(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        if (n > 0){
            System.out.printf("The number %d is positive.", n);
        }else if (n < 0){
            System.out.printf("The number %d is negative.", n);
        }else {
            System.out.printf("The number %d is zero.", n);
        }
    }

}
