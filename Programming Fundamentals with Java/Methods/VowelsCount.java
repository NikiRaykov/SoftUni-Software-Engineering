import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine().toLowerCase();

        int vowelsCounter = vowelsCount(line);
        System.out.println(vowelsCounter);
    }

    public static int vowelsCount(String line){
        int counter = 0;
        for (int i = 0; i <= line.length() - 1; i++) {
            if (line.charAt(i) == 'a' || line.charAt(i) == 'е' || line.charAt(i) == 'i'
                    || line.charAt(i) == 'o'
                    || line.charAt(i) == 'u'){
                counter++;
            }
        }
        return counter;
    }
}
