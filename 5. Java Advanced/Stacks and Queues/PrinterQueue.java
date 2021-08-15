import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printer = new ArrayDeque<>();

        String inputFile = scanner.nextLine();

        while (!inputFile.equals("print")){

            if (!inputFile.equals("cancel")){
                printer.offer(inputFile);
            }else {
                if (printer.isEmpty()){
                    System.out.println("Printer is on standby");
                }else {
                    System.out.println("Canceled " + printer.pollFirst());
                }
            }

            inputFile = scanner.nextLine();
        }
        for (String e: printer){
            System.out.println(e);
        }
    }
}
