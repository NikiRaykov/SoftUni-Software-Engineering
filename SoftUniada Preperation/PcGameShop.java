import java.util.Scanner;

public class PcGameShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int gamesSold = Integer.parseInt(scanner.nextLine());
        double hearthStoneCounter = 0; double forniteCounter = 0; double overwatchCounter = 0;
        double others = 0;

        for (int i = 0; i < gamesSold; i++) {
            String gameName = scanner.nextLine();
            if (gameName.equals("Hearthstone")){
                hearthStoneCounter++;
            }else if (gameName.equals("Fornite")){
                forniteCounter++;
            }else if (gameName.equals("Overwatch")){
                overwatchCounter++;
            }else {
                others++;
            }
        }
        System.out.printf("Hearthstone - %.2f%%%n", (hearthStoneCounter/gamesSold) * 100);
        System.out.printf("Fornite - %.2f%%%n", (forniteCounter/gamesSold) * 100);
        System.out.printf("Overwatch - %.2f%%%n", (overwatchCounter/gamesSold) * 100);
        System.out.printf("Others - %.2f%%", (others/gamesSold) * 100);
    }
}
