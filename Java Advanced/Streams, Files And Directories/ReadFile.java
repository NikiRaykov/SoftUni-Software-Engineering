import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {

        String path = "C:\\Users\\Raykov\\Desktop\\New folder\\input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            int readBytes = inputStream.read();

            while (readBytes != - 1){
                System.out.printf("%s ", Integer.toBinaryString(readBytes));
                readBytes = inputStream.read();
            }
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
