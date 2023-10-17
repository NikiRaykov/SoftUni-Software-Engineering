import java.util.Scanner;

public class FavoriteMovie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movieName = scanner.nextLine();
        int movieCounter = 0; boolean isLimitReached = false; int points = 0; int maxPoints = 0; String bestMovie = " ";

        while (!movieName.equals("STOP")){
            movieCounter++;

            if (movieCounter >= 7){
                isLimitReached = true;
                break;
            }
            points = 0;
            for (int i = 0; i < movieName.length(); i++) {
                char ch = movieName.charAt(i);

                if (ch == ' '){
                    points += movieName.charAt(i);
                }else if (Character.isUpperCase(ch)){
                    points += movieName.charAt(i) - movieName.length();
                }else if (Character.isDigit(ch)){
                    points += movieName.charAt(i);
                }
                else if (!Character.isUpperCase(ch)){
                    points += movieName.charAt(i) - (movieName.length() * 2);
                }
            }
            if (points > maxPoints){
                maxPoints = points;
                bestMovie = movieName;
            }
            movieName = scanner.nextLine();
        }
        if (isLimitReached){
            System.out.println("The limit is reached.");
        }
        System.out.printf("The best movie for you is %s with %d ASCII sum.", bestMovie, maxPoints);

    }
}
