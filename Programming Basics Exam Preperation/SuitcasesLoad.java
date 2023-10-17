import java.util.Scanner;

public class SuitcasesLoad {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double trunkCapacity = Double.parseDouble(scanner.nextLine());
        String command = scanner.nextLine();

        int counter = 0;

        while (!command.equals("End")){
            double suitcaseVolume = Double.parseDouble(command);
            if (suitcaseVolume > trunkCapacity){
                break;
            }
            counter++;

            if (counter == 3){
                suitcaseVolume += (suitcaseVolume / 100) * 10;
            }

            trunkCapacity -= suitcaseVolume;


            command = scanner.nextLine();
        }

        if (command.equals("End")){
            System.out.print("Congratulations! All suitcases are loaded!\n");
        }else {
            System.out.println("No more space!");
        }
        System.out.printf("Statistic: %d suitcases loaded.", counter);

    }
}