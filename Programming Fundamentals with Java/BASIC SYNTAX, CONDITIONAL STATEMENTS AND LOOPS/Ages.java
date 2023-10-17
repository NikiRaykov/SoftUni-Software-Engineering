import java.util.Scanner;

public class Ages {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());

        if (age <= 2){
            System.out.print("baby");
        }else if (age <= 13){
            System.out.print("child");
        }else if (age <= 19){
            System.out.print("teenager");
        }else if (age <=65){
            System.out.print("adult");
        }else {
            System.out.print("elder");
        }
    }
}
