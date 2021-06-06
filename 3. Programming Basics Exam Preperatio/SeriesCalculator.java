import java.util.Scanner;

public class SeriesCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String seriesName = scanner.nextLine();
        int seasons = Integer.parseInt(scanner.nextLine());
        int episodes = Integer.parseInt(scanner.nextLine());
        double durationWithoutCommercials = Double.parseDouble(scanner.nextLine());

        double commercials = durationWithoutCommercials * (20.0f/100.0f);
        double durationWithCommercials = durationWithoutCommercials + commercials;
        double extraTimeFromSpecialsEpisodes = seasons * 10;
        double totalTimeToFinishTheSeries = (durationWithCommercials * episodes * seasons) + extraTimeFromSpecialsEpisodes;
        System.out.printf("Total time needed to watch the %s series is %.0f minutes.",seriesName, Math.floor(totalTimeToFinishTheSeries));
    }
}