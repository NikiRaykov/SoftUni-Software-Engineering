import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int period = Integer.parseInt(scanner.nextLine());
        int doctors = 7;
        int arrivedPatients = 0;
        int treatedPatients = 0;
        int untreatedPatients = 0;
        int treatedPatientsSum = 0;
        int untreatedPatientsSum = 0;

        for (int i = 1; i <= period; i++) {
            arrivedPatients = Integer.parseInt(scanner.nextLine());

            if (i % 3 == 0 && untreatedPatientsSum > treatedPatientsSum){
                doctors++;
            }

            if (arrivedPatients <= 7){
                treatedPatients += arrivedPatients;
            }
            else if (arrivedPatients > doctors){
               untreatedPatients = arrivedPatients - doctors;
            }
            }
        System.out.printf("Treated patients: %d.%n", treatedPatients);
        System.out.printf("Untreated patients: %d.", untreatedPatients);
        }
    }

