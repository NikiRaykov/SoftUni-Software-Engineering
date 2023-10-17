import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double convertNumber =  Double.parseDouble(scanner.nextLine());
        String unit = scanner.nextLine();
        String finalUnit = scanner.nextLine();

        if (unit.equals("mm") && finalUnit.equals("m")) {
            double v = convertNumber / 1000;
            System.out.printf("%.3f", v);
        }
        else if (unit.equals("mm") && finalUnit.equals("cm")){
            double v = convertNumber / 10;
            System.out.printf("%.3f", v);
        }
        else if (unit.equals("cm") && finalUnit.equals("mm")) {
            double v = convertNumber * 10;
            System.out.printf("%.3f", v);
        }
        else if (unit.equals("cm") && finalUnit.equals("m")) {
            double v = convertNumber / 100;
            System.out.printf("%.3f", v);
        }
        else if (unit.equals("m") && finalUnit.equals("cm")) {
            double v = convertNumber * 100;
            System.out.printf("%.3f", v);
        }
        else if (unit.equals("m") && finalUnit.equals("mm")) {
            double v = convertNumber * 1000;
            System.out.printf("%.3f", v);
        }
        else {
            System.out.println("Invalid number");
        }
    }
}
