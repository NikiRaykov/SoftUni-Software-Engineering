import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String favBook = scanner.nextLine(); // favourite book
        boolean isFound = false;
        int countBooks = 0;     // searched books

        String input = scanner.nextLine();
        while (!input.equals("No More Books")){
            if (input.equals(favBook)){
                isFound = true;
                break;
            }
            countBooks++;
            input = scanner.nextLine();
        }

        if (isFound){
            System.out.printf("You checked %d books and found it.", countBooks);
        }
        else {
            System.out.printf("The book you search is not here!\n" +
                    "You checked %d books.", countBooks);
        }
    }
}
