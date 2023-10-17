import java.util.*;
import java.util.stream.Collectors;

public class SoftUniParty {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Set<String> guestList=new TreeSet<>();
        String input;
        while (!"PARTY".equals(input=scan.nextLine())){
            guestList.add(input);
        }
        while (!"END".equals(input=scan.nextLine())){
            guestList.remove(input);
        }
        System.out.printf("%s%n%s",guestList.size(),guestList.stream().collect(Collectors.joining(System.lineSeparator())));
    }
}