import java.util.Scanner;

public class MovieRatings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int moviesToWatch = Integer.parseInt(scanner.nextLine());
        double maxRating = 0; double minRating = 0; double avgRating = 0;
        String movieWithMaxRating = " "; String movieWithMinRating = " ";

        for (int i = 0; i < moviesToWatch; i++) {
            String movieName = scanner.nextLine();
            double movieRating = Double.parseDouble(scanner.nextLine());
            avgRating += movieRating;

            if (movieRating > maxRating){
                if (movieRating != maxRating){
                    maxRating = movieRating;
                    movieWithMaxRating = movieName;
                }
            }else {
                if (movieRating != minRating){
                    minRating = movieRating;
                    movieWithMinRating = movieName;
                }

            }
        }
        System.out.printf("%s is with highest rating: %.1f%n", movieWithMaxRating, maxRating);
        System.out.printf("%s is with lowest rating: %.1f%n", movieWithMinRating, minRating);
        System.out.printf("Average rating: %.1f", avgRating / moviesToWatch);
    }
}
