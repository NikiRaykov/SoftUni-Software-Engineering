import javax.imageio.IIOException;
import java.io.BufferedReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) throws IOException {


        String path = "C:\\Users\\Raykov\\Desktop\\StreamsExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";


        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path))){

            String line = bufferedReader.readLine();

            while (line != null){
                long sum = 0;
                for (char c: line.toCharArray()){
                    sum += c;
                }
                System.out.println(sum);
                line = bufferedReader.readLine();
            }
        } catch (IIOException e) {
            e.printStackTrace();
        }
    }
}
