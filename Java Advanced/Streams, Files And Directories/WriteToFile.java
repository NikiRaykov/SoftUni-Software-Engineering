import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Raykov\\Desktop\\New folder\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        Set<Character> symbols = Set.of(',', '.', '!', '?');

        int nextByte = inputStream.read();

        while (nextByte != -1){
            char symbol = (char) nextByte;
            if (!symbols.contains(symbol)){
                System.out.print(symbol);
            }
            nextByte = inputStream.read();
        }
    }
}
