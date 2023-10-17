import java.util.Scanner;
// Find online more information about ASCII (American Standard Code for Information Interchange)
// and write a program that prints part of the ASCII table of characters at the console.
//On the first line of input you will receive the char index you should start with and on the
//second line - the index of the last character you should print.


public class PrintPartOfTheASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        for (int i = start; i <= end; i++) {
            System.out.print((char) i + " ");
        }
    }
}
