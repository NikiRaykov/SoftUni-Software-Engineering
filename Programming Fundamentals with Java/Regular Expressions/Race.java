import javax.xml.namespace.QName;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regexName = "[A-Za-z]+";
        String distanceRegex = "[0-9]";

        Pattern patternName = Pattern.compile(regexName);
        Pattern patternDistance = Pattern.compile(distanceRegex);


        List<String> racers = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> players = new LinkedHashMap<>();

        racers.forEach(racer -> players.put(racer, 0));

        String input = scanner.nextLine();


        while(!input.equals("end of race")){
            Matcher matcherName = patternName.matcher(input);
            String name = "";
            while (matcherName.find()){
                name += matcherName.group();
            }

            int distance = 0;
            Matcher matcherDistance = patternDistance.matcher(input);
            while (matcherDistance.find()){
                distance += Integer.parseInt(matcherDistance.group());
            }

            if (racers.contains(name)){
                if (!players.containsKey(name)){
                    players.put(name, distance);
                }else {
                    int newDistance = players.get(name);
                    newDistance += distance;
                    players.put(name, newDistance);
                }
            }

            input = scanner.nextLine();
        }

           List<String> firstThree = players.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                   .limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

        System.out.println("1st place: " + firstThree.get(0));
        System.out.println("2nd place: " + firstThree.get(1));
        System.out.println("3rd place: " + firstThree.get(2));
    }
}
