import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int stadiumCapacity = Integer.parseInt(scanner.nextLine());
        int fansNumber = Integer.parseInt(scanner.nextLine());

        double fans1 = 0; // sector A
        double fans2 = 0; // sector B
        double fans3 = 0; // sector V
        double fans4 = 0; // sector G

        for (int i = 0; i < fansNumber; i++) {
                String sector = scanner.nextLine();

                switch (sector){
                    case "A":
                        fans1++;
                       break;
                    case "B":
                        fans2++;
                        break;
                    case "V":
                        fans3++;
                        break;
                    case "G":
                        fans4++;
                        break;
                    default:
                        break;
                }
        }
        System.out.printf("%.2f%%%n", (fans1/fansNumber) * 100);
        System.out.printf("%.2f%%%n", (fans2/fansNumber) * 100);
        System.out.printf("%.2f%%%n", (fans3/fansNumber) * 100);
        System.out.printf("%.2f%%%n", (fans4/fansNumber) * 100);
        System.out.printf("%.2f%%", ((double)fansNumber/(double) stadiumCapacity) * 100);
    }
}
