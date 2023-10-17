package AdvertisementMessage;

import java.util.Random;
import java.util.Scanner;

public class AddMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] phrases = {"Excellent product.", "Such a great product.",
                "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};

        String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};

        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random phrasesRandom = new Random();
        Random eventRandom = new Random();
        Random authorRandom = new Random();
        Random cityRandom = new Random();

        int randomOutputs = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < randomOutputs; i++) {
            int phaseIndex = phrasesRandom.nextInt(phrases.length);
            int eventIndex = eventRandom.nextInt(events.length);
            int authorIndex = authorRandom.nextInt(authors.length);
            int citiesIndex = cityRandom.nextInt(cities.length);

            System.out.println(phrases[phaseIndex] + events[eventIndex] + authors[authorIndex] + "-" + cities[citiesIndex]);
        }
    }
}
