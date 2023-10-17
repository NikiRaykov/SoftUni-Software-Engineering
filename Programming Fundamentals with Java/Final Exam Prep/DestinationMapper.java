import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "(?<surround>[=\\/])(?<name>[A-Z][A-Za-z]{2,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> destinations = new ArrayList<>();

        while (matcher.find()){
            destinations.add(matcher.group("name"));
        }

        int travelPoints = 0;

        for (String destination: destinations){
            travelPoints += destination.length();
        }


        if (destinations.size() == 0){
            System.out.println("Destinations:");
        }else {
            System.out.println("Destinations: " + String.join(", ", destinations));
        }
        System.out.printf("Travel Points: %d", travelPoints);
    }
}
