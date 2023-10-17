import java.util.Scanner;

public class VacationBooksList {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                int allSheets = Integer.parseInt(scanner.nextLine());
                int sheetsPerHour = Integer.parseInt(scanner.nextLine());
                int days = Integer.parseInt(scanner.nextLine());

                int totalTime = allSheets / sheetsPerHour;
                int HoursPerDay = totalTime / days;

                System.out.println(HoursPerDay);
        }
}