import java.util.Scanner;

public class StreamOfLetters {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String symbol = scanner.nextLine();
        StringBuilder word = new StringBuilder();
        StringBuilder pass = new StringBuilder();
        StringBuilder pass2 = new StringBuilder();
        int c = 0;
        int o = 0;
        int n = 0;

        while (!symbol.equals("End")){

            if (symbol.equals("c")){
                pass.append(symbol);
                c++;
                if (c > 10){
                    word.append(symbol);
                }
            }
            else if (symbol.equals("o")){
                pass.append(symbol);
                o++;
                if (o > 10){
                    word.append(symbol);
                }
            }
            else if (symbol.equals("n")){
                pass.append(symbol);
                n++;
                if (n > 10){
                    word.append(symbol);
                }
            }
            else {
                word.append(symbol);
            }

            symbol = symbol.replaceAll("[^a-zA-Z0-9]", "");
            symbol = scanner.nextLine();
        }
        System.out.println(word);
    }
}
