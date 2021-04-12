import java.util.Scanner;

public class CharactersIn {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char a = scanner.next().charAt(0); // char chr = sc.next().charAt(0);
        char b = scanner.next().charAt(0);
        charactersInBetween(a, b);

        }
        public static void charactersInBetween(char a, char b){
            for (int i = a + 1; i < b; i++) {
                System.out.print((char) i + " ");
            }
        }
    }

