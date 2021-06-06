import java.util.Scanner;

public class EasterEggs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int eggs = Integer.parseInt(scanner.nextLine());

        int redEgg = 0; int orangeEgg = 0; int blueEgg = 0; int greenEgg = 0; int maxNumber = Integer.MIN_VALUE; String maxEggs = "";

        for (int i = 1; i <= eggs ; i++) {
            String color = scanner.nextLine();

            switch (color){
                case "red":
                    redEgg++;
                    break;

                case "orange":
                    orangeEgg++;
                    break;

                case "blue":
                    blueEgg++;
                    break;

                case "green":
                    greenEgg++;
                    break;
            }
        }
        if (blueEgg >= maxNumber)
        {
            maxNumber = blueEgg;
            maxEggs = "blue";
        }

        if (redEgg >= maxNumber)
        {
            maxNumber = redEgg;
            maxEggs = "red";
        }

        if (orangeEgg >= maxNumber)
        {
            maxNumber = orangeEgg;
            maxEggs = "orange";
        }

        if (greenEgg >= maxNumber)
        {
            maxNumber = greenEgg;
            maxEggs = "green";
        }
        System.out.printf("Red eggs: %d\n", redEgg);
        System.out.printf("Orange eggs: %d\n", orangeEgg);
        System.out.printf("Blue eggs: %d\n", blueEgg);
        System.out.printf("Green eggs: %d\n", greenEgg);
        System.out.printf("Max eggs: %d -> %s", maxNumber, maxEggs);
    }
}

