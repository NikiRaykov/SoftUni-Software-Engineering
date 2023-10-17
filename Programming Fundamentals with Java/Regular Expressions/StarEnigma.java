import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfMessages = Integer.parseInt(scanner.nextLine());

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 0; i < numberOfMessages; i++) {
            String encryptedMessage = scanner.nextLine();
            String regexForKey = "[STARstar]";
            Pattern patternForKey = Pattern.compile(regexForKey);
            Matcher matcherForKey = patternForKey.matcher(encryptedMessage);
            int key = 0;
            while (matcherForKey.find()){
                key++;
            }

            //We decrypt the message
            char[] charArray = encryptedMessage.toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                charArray[j] -= key;
            }

            String decryptedMessage = String.valueOf(charArray);
            String regexForPlanets = "@(?<planetName>[A-Za-z]+)[^@!:>-]*:(?<population>\\d+)(?<mark>!)(?<type>[A-Z])\\3->(?<soldiers>\\d+)";
            Pattern patternForPlanets = Pattern.compile(regexForPlanets);

            Matcher matcherForPlanets = patternForPlanets.matcher(decryptedMessage);

            while (matcherForPlanets.find()){
                if (matcherForPlanets.group("type").equals(String.valueOf('A'))){
                    attackedPlanets.add(matcherForPlanets.group("planetName"));
                }else if (matcherForPlanets.group("type").equals(String.valueOf('D'))){
                    destroyedPlanets.add(matcherForPlanets.group("planetName"));
                }
            }
        }

        if (attackedPlanets.size() == 0){
            System.out.println("Attacked planets: 0");
        }else {
            System.out.println("Attacked planets: " + attackedPlanets.size());
            Collections.reverse(attackedPlanets);
            for (String planetAttacked: attackedPlanets){
                System.out.println("-> " + planetAttacked);
            }
        }

        if (destroyedPlanets.size() == 0){
            System.out.println("Destroyed planets: 0");
        }else {
            System.out.println("Destroyed planets: " + destroyedPlanets.size());
            Collections.reverse(destroyedPlanets);
            for (String destroyedPlanet: destroyedPlanets){
                System.out.println("-> " + destroyedPlanet);
            }
        }
    }
}
