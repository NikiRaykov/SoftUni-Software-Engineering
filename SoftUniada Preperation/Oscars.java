import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String actorName = scanner.nextLine();
        double pointsFromTheAcademy = Double.parseDouble(scanner.nextLine());
        int evaluatingCount = Integer.parseInt(scanner.nextLine());
        double pointsCalculated = 0.0; boolean areEnough = false; int counter = 0;

        for (int i = 0; i < evaluatingCount; i++) {
                String evaluatingPersonName = scanner.nextLine();
                double evaluatingPersonPointsGiven = Double.parseDouble(scanner.nextLine());
                counter++;

                if (counter == 1){
                    pointsCalculated += ((evaluatingPersonName.length() * evaluatingPersonPointsGiven) / 2) + pointsFromTheAcademy;
                }else {
                    pointsCalculated += ((evaluatingPersonName.length() * evaluatingPersonPointsGiven) / 2);
                }


                if (pointsCalculated > 1250.5){
                    areEnough = true;
                    break;
                }
        }
        if (areEnough){
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName, pointsCalculated);
        }else {
            System.out.printf("Sorry, %s you need %.1f more!", actorName, 1250.5 - pointsCalculated);
        }
    }
}
